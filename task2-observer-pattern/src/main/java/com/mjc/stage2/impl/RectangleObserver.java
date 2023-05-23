package com.mjc.stage2.impl;

import com.mjc.stage2.Observer;
import com.mjc.stage2.entity.Rectangle;
import com.mjc.stage2.entity.RectangleValues;
import com.mjc.stage2.event.RectangleEvent;
import com.mjc.stage2.warehouse.RectangleWarehouse;

public class RectangleObserver implements Observer {
    @Override
    public void handleEvent(RectangleEvent event) {
        final Rectangle modifiedRectangle = event.getSource();
        final double recSquare = modifiedRectangle.getSideA() * modifiedRectangle.getSideB();
        final double recPerimeter = 2 * (modifiedRectangle.getSideA() + modifiedRectangle.getSideB());
        RectangleValues updatedValues = new RectangleValues(recSquare, recPerimeter);
        RectangleWarehouse.getInstance().put(modifiedRectangle.getId(), updatedValues );
        System.out.println("Event processed: rec: " + modifiedRectangle.getId());
    }
}
