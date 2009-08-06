 /**
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
package org.jdesktop.wonderland.modules.avatarbase.client.jme.cellrenderer;

import com.jme.math.Vector3f;
import imi.character.CharacterEyes;
import imi.character.CharacterMotionListener;
import imi.character.avatar.AvatarContext.TriggerNames;
import imi.scene.PMatrix;
import java.text.DecimalFormat;
import java.util.logging.Logger;
import org.jdesktop.wonderland.client.ClientContext;
import org.jdesktop.wonderland.modules.avatarbase.client.jme.cellrenderer.AvatarRendererChangeRequestEvent.AvatarQuality;

/**
 * A test to demonstrate triggering motion from other interfaces
 *
 * @author paulby
 */
public class AvatarTestPanel extends javax.swing.JPanel {

    private WlAvatarCharacter avatarCharacter;
    private DecimalFormat floatFormat = new DecimalFormat("#####.00");

    private CharacterMotionListener motionListener;

    /** Creates new form AvatarTestPanel */
    public AvatarTestPanel() {
        initComponents();

        expressionCB.removeAllItems();
        expressionCB.addItem(TriggerNames.Smile);
        expressionCB.addItem(TriggerNames.Frown);
        expressionCB.addItem(TriggerNames.Scorn);

        motionListener = new CharacterMotionListener() {

                public void transformUpdate(Vector3f translation, PMatrix rotation) {
                    StringBuffer buf = new StringBuffer();
                    buf.append(floatFormat.format(translation.x));
                    buf.append(", "+floatFormat.format(translation.y));
                    buf.append(", "+floatFormat.format(translation.z));
                    locationTF.setText(buf.toString());
                }
            };

        setAvatarCharacter(null);
    }

    public void setAvatarCharacter(WlAvatarCharacter avatar) {

        if (avatarCharacter!=null)
            avatarCharacter.getContext().getController().removeCharacterMotionListener(motionListener);

        avatarCharacter = avatar;

        boolean enabled = (avatar!=null);

        if (enabled) {
            actionCB.removeAllItems();
            for(String anim : avatar.getAnimationNames()) {
                actionCB.addItem(anim);
            }
            avatarCharacter.getContext().getController().addCharacterMotionListener(motionListener);
            motionListener.transformUpdate(avatarCharacter.getContext().getController().getPosition(), null);
        } else {
            actionCB.removeAllItems();
        }

        forwardB.setEnabled(enabled);
        rightB.setEnabled(enabled);
        backwardB.setEnabled(enabled);
        leftB.setEnabled(enabled);
        actionCB.setEnabled(enabled);
//        expressionCB.setEnabled(enabled);

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSlider1 = new javax.swing.JSlider();
        jPanel1 = new javax.swing.JPanel();
        forwardB = new javax.swing.JButton();
        backwardB = new javax.swing.JButton();
        leftB = new javax.swing.JButton();
        rightB = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        locationTF = new javax.swing.JTextField();
        homeB = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        actionCB = new javax.swing.JComboBox();
        runActionB = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        expressionCB = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        renderQuality = new javax.swing.JComboBox();
        winkB = new javax.swing.JButton();
        eyeSelectionCB = new javax.swing.JComboBox();
        closeButton = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Movement"));

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("org/jdesktop/wonderland/modules/avatarbase/client/resources/Bundle"); // NOI18N
        forwardB.setText(bundle.getString("Forward")); // NOI18N
        forwardB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                directionBMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                directionBMouseReleased(evt);
            }
        });

        backwardB.setText(bundle.getString("Backward")); // NOI18N
        backwardB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                directionBMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                directionBMouseReleased(evt);
            }
        });

        leftB.setText(bundle.getString("Left")); // NOI18N
        leftB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                directionBMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                directionBMouseReleased(evt);
            }
        });

        rightB.setText(bundle.getString("Right")); // NOI18N
        rightB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                directionBMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                directionBMouseReleased(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(44, 44, 44)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(69, 69, 69)
                        .add(forwardB)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 65, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                            .add(leftB)
                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 83, Short.MAX_VALUE)
                            .add(rightB))
                        .add(jPanel1Layout.createSequentialGroup()
                            .add(69, 69, 69)
                            .add(backwardB)
                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 65, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                .add(57, 57, 57))
        );

        jPanel1Layout.linkSize(new java.awt.Component[] {backwardB, forwardB}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        jPanel1Layout.linkSize(new java.awt.Component[] {leftB, rightB}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(forwardB)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(rightB)
                    .add(leftB))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(backwardB)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setText(bundle.getString("Location:")); // NOI18N

        locationTF.setEditable(false);

        homeB.setText(bundle.getString("Go_home")); // NOI18N
        homeB.setToolTipText(bundle.getString("Go_to_0,0,0")); // NOI18N
        homeB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeBActionPerformed(evt);
            }
        });

        jLabel1.setText(bundle.getString("Action:")); // NOI18N

        actionCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionCBActionPerformed(evt);
            }
        });

        runActionB.setText(bundle.getString("Run")); // NOI18N
        runActionB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runActionBActionPerformed(evt);
            }
        });

        jLabel2.setText(bundle.getString("Expression:")); // NOI18N

        expressionCB.setEnabled(false);
        expressionCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                expressionCBActionPerformed(evt);
            }
        });

        jLabel3.setText(bundle.getString("Render_Quality:")); // NOI18N

        renderQuality.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "High", "Medium", "Low" }));
        renderQuality.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                renderQualityActionPerformed(evt);
            }
        });

        winkB.setText(bundle.getString("Wink")); // NOI18N
        winkB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                winkBActionPerformed(evt);
            }
        });

        eyeSelectionCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Left Eye", "Right Eye" }));

        closeButton.setText(bundle.getString("Close")); // NOI18N
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(6, Short.MAX_VALUE))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel4)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel1)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel2)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel3))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(6, 6, 6)
                        .add(closeButton))
                    .add(layout.createSequentialGroup()
                        .add(renderQuality, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(124, 124, 124))
                    .add(layout.createSequentialGroup()
                        .add(eyeSelectionCB, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 144, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(winkB))
                    .add(layout.createSequentialGroup()
                        .add(expressionCB, 0, 144, Short.MAX_VALUE)
                        .add(81, 81, 81))
                    .add(layout.createSequentialGroup()
                        .add(actionCB, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 144, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(runActionB))
                    .add(layout.createSequentialGroup()
                        .add(homeB)
                        .add(125, 125, 125))
                    .add(locationTF, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE))
                .addContainerGap())
        );

        layout.linkSize(new java.awt.Component[] {runActionB, winkB}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        layout.linkSize(new java.awt.Component[] {actionCB, expressionCB, eyeSelectionCB}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(locationTF, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel4))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(homeB)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(actionCB, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(runActionB))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(expressionCB, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(eyeSelectionCB, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(winkB))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(renderQuality, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel3))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(closeButton)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void directionBMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_directionBMousePressed
        if (evt.getSource()==forwardB) {
            avatarCharacter.triggerActionStart(TriggerNames.Move_Forward);
        } else if (evt.getSource()==rightB) {
            avatarCharacter.triggerActionStart(TriggerNames.Move_Right);
        } else if (evt.getSource()==backwardB) {
            avatarCharacter.triggerActionStart(TriggerNames.Move_Back);
        } else if (evt.getSource()==leftB) {
            avatarCharacter.triggerActionStart(TriggerNames.Move_Left);
        }

}//GEN-LAST:event_directionBMousePressed

    private void directionBMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_directionBMouseReleased
        if (evt.getSource()==forwardB) {
            avatarCharacter.triggerActionStop(TriggerNames.Move_Forward);
        } else if (evt.getSource()==rightB) {
            avatarCharacter.triggerActionStop(TriggerNames.Move_Right);
        } else if (evt.getSource()==backwardB) {
            avatarCharacter.triggerActionStop(TriggerNames.Move_Back);
        } else if (evt.getSource()==leftB) {
            avatarCharacter.triggerActionStop(TriggerNames.Move_Left);
        }

}//GEN-LAST:event_directionBMouseReleased

    private void expressionCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_expressionCBActionPerformed
//        if (avatarCharacter!=null) {
//            avatarCharacter.triggerActionStart((TriggerNames) expressionCB.getSelectedItem());
//        }
    }//GEN-LAST:event_expressionCBActionPerformed

    private void runActionBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runActionBActionPerformed
        if (avatarCharacter!=null) {
            avatarCharacter.playAnimation(actionCB.getSelectedItem().toString());
        }
}//GEN-LAST:event_runActionBActionPerformed

    private void renderQualityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_renderQualityActionPerformed
        switch(renderQuality.getSelectedIndex()) {
            case 0 :
                ClientContext.getInputManager().postEvent(new AvatarRendererChangeRequestEvent(AvatarQuality.High));
                break;
            case 1:
                ClientContext.getInputManager().postEvent(new AvatarRendererChangeRequestEvent(AvatarQuality.Medium));
                break;
            case 2 :
                ClientContext.getInputManager().postEvent(new AvatarRendererChangeRequestEvent(AvatarQuality.Low));
                break;
            default :
                Logger.getAnonymousLogger().severe("Unknown_render_quality");
                return;
        }
}//GEN-LAST:event_renderQualityActionPerformed

    private void winkBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_winkBActionPerformed
        CharacterEyes eyes = avatarCharacter.getEyes();

        eyes.wink((eyeSelectionCB.getSelectedIndex()==1));

}//GEN-LAST:event_winkBActionPerformed

    private void actionCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actionCBActionPerformed

    }//GEN-LAST:event_actionCBActionPerformed

    private void homeBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeBActionPerformed
        avatarCharacter.goTo(new Vector3f(0,0,0), new Vector3f(0,0,-1));
}//GEN-LAST:event_homeBActionPerformed

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        getParent().setVisible(false);
}//GEN-LAST:event_closeButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox actionCB;
    private javax.swing.JButton backwardB;
    private javax.swing.JButton closeButton;
    private javax.swing.JComboBox expressionCB;
    private javax.swing.JComboBox eyeSelectionCB;
    private javax.swing.JButton forwardB;
    private javax.swing.JButton homeB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JButton leftB;
    private javax.swing.JTextField locationTF;
    private javax.swing.JComboBox renderQuality;
    private javax.swing.JButton rightB;
    private javax.swing.JButton runActionB;
    private javax.swing.JButton winkB;
    // End of variables declaration//GEN-END:variables

}