package com.jsql.view.swing.panel.split;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.jsql.view.swing.util.MediatorHelper;

/**
 * MouseAdapter to show/hide bottom panel.
 */
public class ActionHideShowResult implements ActionListener {
    
    /**
     * Hide bottom panel if both main and bottom are visible, also
     * displays an ersatz bar replacing tabbedpane.
     * Or else if only main panel is visible then displays bottom panel
     * and hide ersatz panel.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (
            MediatorHelper.frame().getSplitHorizontalTopBottom().getTopComponent().isVisible()
            && MediatorHelper.frame().getSplitHorizontalTopBottom().getBottomComponent().isVisible()
        ) {
            
            MediatorHelper.panelConsoles().setDividerLocation(MediatorHelper.frame().getSplitHorizontalTopBottom().getDividerLocation());
            MediatorHelper.frame().getSplitHorizontalTopBottom().getTopComponent().setVisible(false);
            MediatorHelper.frame().getSplitHorizontalTopBottom().disableDragSize();
            MediatorHelper.panelConsoles().getButtonShowNorth().setVisible(false);
        } else if (
            MediatorHelper.frame().getSplitHorizontalTopBottom().getTopComponent().isVisible()
            && !MediatorHelper.frame().getSplitHorizontalTopBottom().getBottomComponent().isVisible()
        ) {
            
            MediatorHelper.frame().getSplitHorizontalTopBottom().setDividerLocation(MediatorHelper.panelConsoles().getDividerLocation());
            MediatorHelper.frame().getSplitHorizontalTopBottom().getBottomComponent().setVisible(true);
            MediatorHelper.frame().getSplitHorizontalTopBottom().getTopComponent().setVisible(true);
            MediatorHelper.frame().getSplitHorizontalTopBottom().enableDragSize();
        }
    }
}