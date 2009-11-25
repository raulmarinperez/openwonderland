/*
 * Project Wonderland
 *
 * Copyright (c) 2004-2009, Sun Microsystems, Inc., All Rights Reserved
 *
 * Redistributions in source code form must reproduce the above
 * copyright and this condition.
 *
 * The contents of this file are subject to the GNU General Public
 * License, Version 2 (the "License"); you may not use this file
 * except in compliance with the License. A copy of the License is
 * available at http://www.opensource.org/licenses/gpl-license.php.
 *
 * Sun designates this particular file as subject to the "Classpath"
 * exception as provided by Sun in the License file that accompanied
 * this code.
 */
package org.jdesktop.wonderland.modules.audiomanager.client.voicechat;

import org.jdesktop.wonderland.modules.audiomanager.common.VolumeConverter;

import java.awt.event.ActionListener;
import javax.swing.event.ChangeListener;

/**
 *
 * @author nsimpson
 */
public class HoldPanel extends javax.swing.JPanel {

    private VolumeConverter volumeConverter;

    public HoldPanel() {
        initComponents();

	volumeConverter = new VolumeConverter(volumeSlider.getMaximum());
    }

    public void addHoldListener(ActionListener listener) {
        takeOffHoldButton.addActionListener(listener);
    }

    public void removeHoldListener(ActionListener listener) {
        takeOffHoldButton.removeActionListener(listener);
    }

    public void addVolumeChangeListener(ChangeListener listener) {
       volumeSlider.addChangeListener(listener);
    }

    public void removeVolumeChangeListener(ChangeListener listener) {
        volumeSlider.removeChangeListener(listener);
    }

    public float getHoldVolume() {
	return volumeConverter.getVolume(volumeSlider.getValue());
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        holdLabel = new javax.swing.JLabel();
        holdingUsersLabel = new javax.swing.JLabel();
        takeOffHoldButton = new javax.swing.JButton();
        volumeSlider = new javax.swing.JSlider();

        setName("Form"); // NOI18N

        holdLabel.setFont(holdLabel.getFont().deriveFont(holdLabel.getFont().getStyle() | java.awt.Font.BOLD));
        holdLabel.setText("On hold volume:");
        holdLabel.setName("holdLabel"); // NOI18N

        holdingUsersLabel.setText(" ");
        holdingUsersLabel.setName("holdingUsersLabel"); // NOI18N

        takeOffHoldButton.setText("Take Off Hold");
        takeOffHoldButton.setName("takeOffHoldButton"); // NOI18N

        volumeSlider.setMinorTickSpacing(10);
        volumeSlider.setName("volumeSlider"); // NOI18N
        volumeSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                volumeSliderStateChanged(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(holdLabel)
                    .add(holdingUsersLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, volumeSlider, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, takeOffHoldButton))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(holdLabel)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(volumeSlider, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 17, Short.MAX_VALUE)
                .add(holdingUsersLabel)
                .add(18, 18, 18)
                .add(takeOffHoldButton)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void volumeSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_volumeSliderStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_volumeSliderStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel holdLabel;
    private javax.swing.JLabel holdingUsersLabel;
    private javax.swing.JButton takeOffHoldButton;
    private javax.swing.JSlider volumeSlider;
    // End of variables declaration//GEN-END:variables
}
