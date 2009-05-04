/*
 * PlaceCallDialog.java
 *
 * Created on April 20, 2009, 11:47 AM
 */
package org.jdesktop.wonderland.modules.audiomanager.client;

import org.jdesktop.wonderland.common.cell.CellID;

import org.jdesktop.wonderland.modules.audiomanager.common.messages.VoiceChatJoinMessage;
import org.jdesktop.wonderland.modules.audiomanager.common.messages.VoiceChatMessage.ChatType;

import org.jdesktop.wonderland.modules.presencemanager.client.PresenceManager;
import org.jdesktop.wonderland.modules.presencemanager.client.PresenceManagerFactory;
import org.jdesktop.wonderland.modules.presencemanager.client.PresenceManagerListener;
import org.jdesktop.wonderland.modules.presencemanager.client.PresenceManagerListener.ChangeType;
import org.jdesktop.wonderland.modules.presencemanager.common.PresenceInfo;

import org.jdesktop.wonderland.modules.avatarbase.client.jme.cellrenderer.NameTagNode;

import org.jdesktop.wonderland.client.comms.WonderlandSession;

import java.io.IOException;

import java.util.ArrayList;


import java.util.logging.Logger;


import java.awt.Point;

/**
 *
 * @author  jp
 */
public class PlaceCallDialog extends javax.swing.JFrame implements PresenceManagerListener,
	KeypadListener {

    private static final Logger logger =
            Logger.getLogger(PlaceCallDialog.class.getName());
    private ChatType chatType = ChatType.PRIVATE;
    private AudioManagerClient client;
    private WonderlandSession session;
    private CellID cellID;
    private PresenceInfo caller;
    private PresenceManager pm;
    private int chatGroupNumber;

    /** Creates new form PlaceCallDialog */
    public PlaceCallDialog() {
        initComponents();
    }

    public PlaceCallDialog(AudioManagerClient client, WonderlandSession session,
            CellID cellID, PresenceInfo caller) throws IOException {

        this.client = client;
        this.cellID = cellID;
        this.session = session;
        this.caller = caller;

        initComponents();

        pm = PresenceManagerFactory.getPresenceManager(session);

        pm.addPresenceManagerListener(this);

        setVisible(true);
    }

    public void presenceInfoChanged(PresenceInfo presenceInfo, ChangeType type) {
        setBuddyList();
    }

    public void aliasChanged(String previousAlias, PresenceInfo presenceInfo) {
        setBuddyList();
    }

    private void setBuddyList() {
        PresenceInfo[] presenceInfoList = pm.getAllUsers();

        PresenceInfo ourInfo = pm.getPresenceInfo(cellID);

        ArrayList<String> userData = new ArrayList();

        for (int i = 0; i < presenceInfoList.length; i++) {
            PresenceInfo info = presenceInfoList[i];

            if (info.callID == null) {
                // It's a virtual player, skip it.
                continue;
            }

            //if (info.callID.equals(ourInfo.callID)) {
            //    // It's us, skip it.
            //    continue;
            //}

            userData.add(NameTagNode.getDisplayName(info.usernameAlias,
                info.isSpeaking, info.isMuted));
        }

        buddyList.setListData(userData.toArray(new String[0]));

	enableButtons();
    }

    private void enableButtons() {
        if (buddyList.getSelectedValues().length > 0 ||
                (phoneNumberTextField.getText().replaceAll(" ", "").length() > 0 &&
                nameTextField.getText().replaceAll(" ", "").length() > 0)) {

            placeCallButton.setEnabled(true);
        } else {
            placeCallButton.setEnabled(false);
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        secretRadioButton = new javax.swing.JRadioButton();
        privateRadioButton = new javax.swing.JRadioButton();
        publicRadioButton = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        phoneNumberTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        placeCallButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        buddyList = new javax.swing.JList();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        keyPadButton = new javax.swing.JButton();

        setTitle("Voice Chat");

        buttonGroup1.add(secretRadioButton);
        secretRadioButton.setText("Secret");
        secretRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                secretRadioButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(privateRadioButton);
        privateRadioButton.setSelected(true);
        privateRadioButton.setText("Private");
        privateRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                privateRadioButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(publicRadioButton);
        publicRadioButton.setText("Public");
        publicRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                publicRadioButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("Phone Number:");

        phoneNumberTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneNumberTextFieldActionPerformed(evt);
            }
        });

        jLabel4.setText("Users:");

        placeCallButton.setText("Place Call");
        placeCallButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                placeCallButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        buddyList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        buddyList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                buddyListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(buddyList);

        jLabel2.setText("Privacy:");

        jLabel5.setText("Name:");

        nameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTextFieldActionPerformed(evt);
            }
        });

        keyPadButton.setText("KeyPad");
        keyPadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keyPadButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(placeCallButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 99, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                                .add(jLabel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 56, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(4, 4, 4)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                                    .add(layout.createSequentialGroup()
                                        .add(cancelButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 87, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 116, Short.MAX_VALUE))))
                            .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                                .add(103, 103, 103)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(nameTextField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                                    .add(phoneNumberTextField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                                    .add(org.jdesktop.layout.GroupLayout.TRAILING, keyPadButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 94, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                        .add(63, 63, 63))
                    .add(layout.createSequentialGroup()
                        .add(jLabel2)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(secretRadioButton)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(privateRadioButton)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(publicRadioButton)
                        .add(52, 52, 52))
                    .add(layout.createSequentialGroup()
                        .add(jLabel3)
                        .addContainerGap(226, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .add(jLabel5)
                        .addContainerGap(283, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(secretRadioButton)
                    .add(privateRadioButton)
                    .add(publicRadioButton))
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel3)
                    .add(phoneNumberTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel5)
                    .add(nameTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(4, 4, 4)
                .add(keyPadButton)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 117, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(placeCallButton)
                            .add(cancelButton)))
                    .add(jLabel4))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
    setVisible(false);
}//GEN-LAST:event_cancelButtonActionPerformed

private void placeCallButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_placeCallButtonActionPerformed
    String chatGroup = caller.userID.getUsername() + "-" + chatGroupNumber++;

    String chatters = "";

    Object[] selectedValues = buddyList.getSelectedValues();

    for (int i = 0; i < selectedValues.length; i++) {
        if (i > 0) {
            chatters += " ";
        }

	chatters += NameTagNode.getUsername((String) selectedValues[i]);
    }

    String callerString = caller.usernameAlias;

    chatters = chatters.replaceAll(" " + callerString, "");
    chatters = chatters.replaceAll(callerString + " ", "");
    chatters = chatters.replaceAll(callerString, "");

    logger.info("JOIN chatGroup " + chatGroup + " caller " + caller + " chatters " + chatters + " chatType " + chatType);

    PresenceInfo[] chattersInfo = new PresenceInfo[0];

    if (chatters.length() > 0) {
        chattersInfo = getPresenceInfo(chatters);
    }

    InCallDialog inCallDialog = new InCallDialog(client, session, cellID, chatGroup, chatType);

    inCallDialog.setLocation(new Point((int) getLocation().getX() + getWidth(), (int) getLocation().getY()));

    session.send(client, new VoiceChatJoinMessage(chatGroup, caller, chattersInfo, chatType,
	phoneNumberTextField.getText(), nameTextField.getText()));

    logger.info("Sent join message, about to enable leave button");
}//GEN-LAST:event_placeCallButtonActionPerformed

private void secretRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_secretRadioButtonActionPerformed
    chatType = ChatType.SECRET;
}//GEN-LAST:event_secretRadioButtonActionPerformed

private void privateRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_privateRadioButtonActionPerformed
    chatType = ChatType.PRIVATE;
}//GEN-LAST:event_privateRadioButtonActionPerformed

private void publicRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_publicRadioButtonActionPerformed
    chatType = ChatType.PUBLIC;
}//GEN-LAST:event_publicRadioButtonActionPerformed

private void phoneNumberTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneNumberTextFieldActionPerformed
    enableButtons();
}//GEN-LAST:event_phoneNumberTextFieldActionPerformed

private void buddyListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_buddyListValueChanged
    enableButtons();
}//GEN-LAST:event_buddyListValueChanged

private void nameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTextFieldActionPerformed
    enableButtons();
}//GEN-LAST:event_nameTextFieldActionPerformed

private KeypadDialog keypad;

private void keyPadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keyPadButtonActionPerformed
    if (keypad == null) {
        keypad = new KeypadDialog(this);
        keypad.setListener(this);
        keypad.setLocation(new Point((int) getLocation().getX() + getWidth(), (int) getLocation().getY()));
    }

    keypad.setVisible(true);
}//GEN-LAST:event_keyPadButtonActionPerformed

public void keypadPressed(char key) {
    System.out.println("Got key " + key);
}

private PresenceInfo[] getPresenceInfo(String users) {
    String[] tokens = users.split(" ");

        PresenceInfo[] info = new PresenceInfo[tokens.length];

        for (int i = 0; i < tokens.length; i++) {
            PresenceInfo[] userInfo = pm.getUserPresenceInfo(tokens[i]);

            if (userInfo == null) {
                logger.warning("No PresenceInfo for " + tokens[i]);
                return null;
            }

            info[i] = userInfo[0];

            checkLength(userInfo);
        }

        return info;
    }

    private void checkLength(PresenceInfo[] info) {
        if (info.length > 1) {
            logger.info("More than one PresenceInfo, using first:");

            for (int i = 0; i < info.length; i++) {
                logger.info("  " + info[i]);
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new PlaceCallDialog().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList buddyList;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton keyPadButton;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JTextField phoneNumberTextField;
    private javax.swing.JButton placeCallButton;
    private javax.swing.JRadioButton privateRadioButton;
    private javax.swing.JRadioButton publicRadioButton;
    private javax.swing.JRadioButton secretRadioButton;
    // End of variables declaration//GEN-END:variables
}
