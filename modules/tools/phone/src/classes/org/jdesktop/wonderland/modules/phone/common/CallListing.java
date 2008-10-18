/**
 * Project Looking Glass
 * 
 * $RCSfile: CallListing.java,v $
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
 * $Revision: 1.9 $
 * $Date: 2008/06/12 18:48:16 $
 * $State: Exp $ 
 */

package org.jdesktop.wonderland.modules.phone.common;

import java.io.Serializable;

/**
 * A convenience class to encapsulate basic call information.
 * @author jh215363
 */
public class CallListing implements Serializable{
    
    private String contactName;
    private String contactNumber;                

    //NOTE: Having a non-empty privateClientName is an implicit declaration
    //that this is a private call.
    private String privateClientName; 
        
    private boolean demoMode;

    private String callID;
    
    /**
     * This constructor allows you to fully specify all of the listings
     * parameters.
     * 
     * @param listingID A unique identifier. If not NULL, must ensure uniqueness.
     * @param contactName The name of ther outworlder on this call
     * @param contactNumber The number used to dial out
     * @param privateClientName The name of the in-world user who is
     * speaking privately on this call. Empty if this call is public.
     */
    public CallListing(String contactName, String contactNumber, String privateClientName, 
	    boolean demoMode) {
            
	this.contactName = contactName;
        this.contactNumber = contactNumber;            
        this.privateClientName = privateClientName;
        this.demoMode = demoMode;

	callID = "";
    }
        
    public String getContactName() {
        return this.contactName;
    }
        
    public String getContactNumber() {
        return this.contactNumber;            
    }
        
    public String getPrivateClientName(){
        return privateClientName;
    }
        
    public void setPrivateClientName(String privateClientName) {
        this.privateClientName = privateClientName;
    }
        
    public boolean demoMode() {
	return demoMode;
    }

    public void setDemoMode(boolean demoMode) {
	this.demoMode = demoMode;
    }

    public void setCallID(String callID) {
	this.callID = callID;
    }

    public String getCallID() {
	return callID;
    }

    @Override
    public String toString() {
        if (privateClientName.length() > 0) {
            return "(Private) " + privateClientName + " with " + contactName + "@" + contactNumber;
        } else {
            return callID + "::" + contactName + " @ " + contactNumber;
        }      
    }
        
    public boolean isPrivate() {
        //HARRISNOTE: For now, private status is implicitly stated by the
        //privateClientName property. This may change in the future.
        if (this.privateClientName.length() == 0) {
            return false;
	}
            
        return true;
    }

    public boolean equals(Object o) {
	if (o instanceof CallListing == false) {
	    return false;
	}

	CallListing listing = (CallListing) o;

        return contactName.equals(listing.getContactName())
	    && contactNumber.equals(listing.getContactNumber());
    }

}
