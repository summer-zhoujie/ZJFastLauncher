package android.support.constraint.solver.widgets;

import android.support.constraint.solver.Cache;
import android.support.p003v7.widget.ActivityChooserView;
import java.util.ArrayList;

public class WidgetContainer extends ConstraintWidget {
    public ArrayList<ConstraintWidget> mChildren = new ArrayList<>();

    public WidgetContainer() {
    }

    public static Rectangle getBounds(ArrayList<ConstraintWidget> arrayList) {
        Rectangle rectangle = new Rectangle();
        if (arrayList.size() == 0) {
            return rectangle;
        }
        int size = arrayList.size();
        int i = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int i2 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            ConstraintWidget constraintWidget = arrayList.get(i5);
            if (constraintWidget.getX() < i) {
                i = constraintWidget.getX();
            }
            if (constraintWidget.getY() < i2) {
                i2 = constraintWidget.getY();
            }
            if (constraintWidget.getRight() > i3) {
                i3 = constraintWidget.getRight();
            }
            if (constraintWidget.getBottom() > i4) {
                i4 = constraintWidget.getBottom();
            }
        }
        rectangle.setBounds(i, i2, i3 - i, i4 - i2);
        return rectangle;
    }

    public void add(ConstraintWidget constraintWidget) {
        this.mChildren.add(constraintWidget);
        if (constraintWidget.getParent() != null) {
            ((WidgetContainer) constraintWidget.getParent()).remove(constraintWidget);
        }
        constraintWidget.setParent(this);
    }

    public ConstraintWidget findWidget(float f, float f2) {
        int drawX = getDrawX();
        int drawY = getDrawY();
        ConstraintWidget constraintWidget = (f < ((float) drawX) || f > ((float) (getWidth() + drawX)) || f2 < ((float) drawY) || f2 > ((float) (getHeight() + drawY))) ? null : this;
        int size = this.mChildren.size();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget2 = this.mChildren.get(i);
            if (constraintWidget2 instanceof WidgetContainer) {
                constraintWidget2 = ((WidgetContainer) constraintWidget2).findWidget(f, f2);
                if (constraintWidget2 == null) {
                }
            } else {
                int drawX2 = constraintWidget2.getDrawX();
                int drawY2 = constraintWidget2.getDrawY();
                int width = constraintWidget2.getWidth() + drawX2;
                int height = constraintWidget2.getHeight() + drawY2;
                if (f >= ((float) drawX2)) {
                    if (f <= ((float) width)) {
                        if (f2 >= ((float) drawY2)) {
                            if (f2 > ((float) height)) {
                            }
                        }
                    }
                }
            }
            constraintWidget = constraintWidget2;
        }
        return constraintWidget;
    }

    public ArrayList<ConstraintWidget> findWidgets(int i, int i2, int i3, int i4) {
        ArrayList<ConstraintWidget> arrayList = new ArrayList<>();
        int size = this.mChildren.size();
        for (int i5 = 0; i5 < size; i5++) {
            ConstraintWidget constraintWidget = this.mChildren.get(i5);
            int drawX = constraintWidget.getDrawX();
            int drawY = constraintWidget.getDrawY();
            if (i >= drawX && i < drawX + constraintWidget.getWidth() && i2 >= drawY && i2 < drawY + constraintWidget.getHeight()) {
                arrayList.add(constraintWidget);
            }
        }
        return arrayList;
    }

    public ArrayList<ConstraintWidget> getChildren() {
        return this.mChildren;
    }

    public ConstraintWidgetContainer getRootConstraintContainer() {
        ConstraintWidget parent = getParent();
        ConstraintWidgetContainer constraintWidgetContainer = this instanceof ConstraintWidgetContainer ? (ConstraintWidgetContainer) this : null;
        while (parent != null) {
            ConstraintWidget parent2 = parent.getParent();
            if (parent instanceof ConstraintWidgetContainer) {
                constraintWidgetContainer = (ConstraintWidgetContainer) parent;
            }
            parent = parent2;
        }
        return constraintWidgetContainer;
    }

    public void layout() {
        updateDrawPosition();
        ArrayList<ConstraintWidget> arrayList = this.mChildren;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ConstraintWidget constraintWidget = this.mChildren.get(i);
                if (constraintWidget instanceof WidgetContainer) {
                    ((WidgetContainer) constraintWidget).layout();
                }
            }
        }
    }

    public void remove(ConstraintWidget constraintWidget) {
        this.mChildren.remove(constraintWidget);
        constraintWidget.setParent((ConstraintWidget) null);
    }

    public void removeAllChildren() {
        this.mChildren.clear();
    }

    public void reset() {
        this.mChildren.clear();
        super.reset();
    }

    public void resetSolverVariables(Cache cache) {
        super.resetSolverVariables(cache);
        int size = this.mChildren.size();
        for (int i = 0; i < size; i++) {
            this.mChildren.get(i).resetSolverVariables(cache);
        }
    }

    public void setOffset(int i, int i2) {
        this.mOffsetX = i;
        this.mOffsetY = i2;
        int size = this.mChildren.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.mChildren.get(i3).setOffset(getRootX(), getRootY());
        }
    }

    public void updateDrawPosition() {
        super.updateDrawPosition();
        ArrayList<ConstraintWidget> arrayList = this.mChildren;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ConstraintWidget constraintWidget = this.mChildren.get(i);
                constraintWidget.setOffset(getDrawX(), getDrawY());
                if (!(constraintWidget instanceof ConstraintWidgetContainer)) {
                    constraintWidget.updateDrawPosition();
                }
            }
        }
    }

    public WidgetContainer(int i, int i2, int i3, int i4) {
        super(i, i2, i3, i4);
    }

    public WidgetContainer(int i, int i2) {
        super(0, 0, i, i2);
    }

    public void add(ConstraintWidget... constraintWidgetArr) {
        for (ConstraintWidget add : constraintWidgetArr) {
            add(add);
        }
    }
}
