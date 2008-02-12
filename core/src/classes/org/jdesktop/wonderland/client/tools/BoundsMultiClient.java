/**
 * Project Wonderland
 *
 * $RCSfile: LogControl.java,v $
 *
 * Copyright (c) 2004-2007, Sun Microsystems, Inc., All Rights Reserved
 *
 * Redistributions in source code form must reproduce the above
 * copyright and this condition.
 *
 * The contents of this file are subject to the GNU General Public
 * License, Version 2 (the "License"); you may not use this file
 * except in compliance with the License. A copy of the License is
 * available at http://www.opensource.org/licenses/gpl-license.php.
 *
 * $Revision: 1.3 $
 * $Date: 2007/10/23 18:27:41 $
 * $State: Exp $
 */
package org.jdesktop.wonderland.client.tools;

import com.jme.bounding.BoundingVolume;
import com.jme.math.FastMath;
import com.jme.math.Quaternion;
import com.jme.math.Vector3f;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdesktop.wonderland.client.avatar.LocalAvatar;
import org.jdesktop.wonderland.client.cell.CellCacheClient;
import org.jdesktop.wonderland.client.comms.LoginParameters;
import org.jdesktop.wonderland.client.comms.SessionStatusListener;
import org.jdesktop.wonderland.client.comms.WonderlandServerInfo;
import org.jdesktop.wonderland.client.comms.WonderlandSession;
import org.jdesktop.wonderland.client.comms.WonderlandSession.Status;
import org.jdesktop.wonderland.common.cell.CellID;
import org.jdesktop.wonderland.common.cell.CellSetup;
import org.jdesktop.wonderland.common.cell.CellTransform;

/**
 *
 * @author jkaplan
 */
public class BoundsMultiClient
        implements CellCacheClient.CellCacheMessageListener,
                   SessionStatusListener
{
    /** a logger */
    private static final Logger logger = 
            Logger.getLogger(BoundsMultiClient.class.getName());
    
    /** the name of this client */
    private String name;
    
    /** the mover thread */
    private MoverThread mover;
    
    public BoundsMultiClient(WonderlandServerInfo server, 
                             LoginParameters login) 
        throws Exception
    {
        this.name = login.getUserName();
        
        // login
        BoundsTestClientSession session =
                new BoundsTestClientSession(server, this);
        session.addSessionStatusListener(this);
        session.login(login);
        
        logger.info(getName() + " login succeeded");
        
        LocalAvatar avatar = session.getLocalAvatar();
        mover = new MoverThread(avatar);
        mover.start();
    }
    
    public String getName() {
        return name;
    }
    
    public void loadCell(CellID cellID, String className, 
                         BoundingVolume localBounds, CellID parentCellID, 
                         String channelName, CellTransform cellTransform,
                         CellSetup setup)
    {
    }

    public void unloadCell(CellID cellID) {
    }

    public void deleteCell(CellID cellID) {
    }

    public void setRootCell(CellID cellID) {
    }

    public void moveCell(CellID cellID, CellTransform cellTransform) {
    }
    
    public void loadClientAvatar(CellID cellID, String className, 
                                 BoundingVolume localBounds, CellID parentCellID, 
                                 String channelName, CellTransform cellTransform, 
                                 CellSetup setup)
    {
    }
    
    public void sessionStatusChanged(WonderlandSession session, 
                                     Status status)
    {
        logger.info(getName() + " change session status: " + status);
        if (status == Status.DISCONNECTED  && mover != null) {
            mover.quit();
        }
    }
    
    public void waitForFinish() throws InterruptedException {
        if (mover == null) {
            return;
        }
        
        // wait for the thread to end
        mover.join();
    }
    
    public static void main(String[] args) {
        WonderlandServerInfo server = new WonderlandServerInfo("localhost", 1139);
        
        int count = 10;
        
        BoundsMultiClient[] bmc = new BoundsMultiClient[count];
        
        for (int i = 0; i < count; i++) {
            LoginParameters login = 
                    new LoginParameters("foo" + i, "test".toCharArray());
            
            try {
                bmc[i] = new BoundsMultiClient(server, login);
                Thread.sleep(500);
            } catch (Exception ex) {
                logger.log(Level.WARNING, "Error logging in", ex);
            }
        }
        
        // wait for each client 
        try {   
            for (BoundsMultiClient client : bmc) {
                client.waitForFinish();
            }
        } catch (InterruptedException ie) {
        }
    }

    class MoverThread extends Thread {
        private Vector3f location = new Vector3f();
        private Quaternion orientation = null;
        private LocalAvatar avatar;
        private boolean quit = false;
        
        public MoverThread(LocalAvatar avatar) {
            this.avatar = avatar;
            
        }

        public synchronized boolean isQuit() {
            return quit;
        }
        
        public synchronized void quit() {
            this.quit = true;
        }
        
        @Override
        public void run() {
            while(!isQuit()) {
                randomPosition();
                avatar.localMoveRequest(location, orientation);
                try {
                    sleep(200);
                } catch (InterruptedException ex) {
                    Logger.getLogger(BoundsMultiClient.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        private void randomPosition() {
            location.x = FastMath.rand.nextFloat()*50;
            location.z = FastMath.rand.nextFloat()*50;
        }
        
    }
}
