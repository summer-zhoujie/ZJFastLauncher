package android.support.constraint.solver.widgets;

import android.support.constraint.solver.widgets.ConstraintAnchor;
import android.support.constraint.solver.widgets.ConstraintWidget;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Analyzer {
    public static void determineGroups(ConstraintWidgetContainer constraintWidgetContainer) {
        if ((constraintWidgetContainer.getOptimizationLevel() & 32) != 32) {
            singleGroup(constraintWidgetContainer);
            return;
        }
        constraintWidgetContainer.mSkipSolver = true;
        constraintWidgetContainer.mGroupsWrapOptimized = false;
        constraintWidgetContainer.mHorizontalWrapOptimized = false;
        constraintWidgetContainer.mVerticalWrapOptimized = false;
        ArrayList<ConstraintWidget> arrayList = constraintWidgetContainer.mChildren;
        List<ConstraintWidgetGroup> list = constraintWidgetContainer.mWidgetGroups;
        boolean z = constraintWidgetContainer.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        boolean z2 = constraintWidgetContainer.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        boolean z3 = z || z2;
        list.clear();
        for (ConstraintWidget next : arrayList) {
            next.mBelongingGroup = null;
            next.mGroupsToSolver = false;
            next.resetResolutionNodes();
        }
        for (ConstraintWidget next2 : arrayList) {
            if (next2.mBelongingGroup == null && !determineGroups(next2, list, z3)) {
                singleGroup(constraintWidgetContainer);
                constraintWidgetContainer.mSkipSolver = false;
                return;
            }
        }
        int i = 0;
        int i2 = 0;
        for (ConstraintWidgetGroup next3 : list) {
            i = Math.max(i, getMaxDimension(next3, 0));
            i2 = Math.max(i2, getMaxDimension(next3, 1));
        }
        if (z) {
            constraintWidgetContainer.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
            constraintWidgetContainer.setWidth(i);
            constraintWidgetContainer.mGroupsWrapOptimized = true;
            constraintWidgetContainer.mHorizontalWrapOptimized = true;
            constraintWidgetContainer.mWrapFixedWidth = i;
        }
        if (z2) {
            constraintWidgetContainer.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
            constraintWidgetContainer.setHeight(i2);
            constraintWidgetContainer.mGroupsWrapOptimized = true;
            constraintWidgetContainer.mVerticalWrapOptimized = true;
            constraintWidgetContainer.mWrapFixedHeight = i2;
        }
        setPosition(list, 0, constraintWidgetContainer.getWidth());
        setPosition(list, 1, constraintWidgetContainer.getHeight());
    }

    public static int getMaxDimension(ConstraintWidgetGroup constraintWidgetGroup, int i) {
        int i2 = i * 2;
        List<ConstraintWidget> startWidgets = constraintWidgetGroup.getStartWidgets(i);
        int size = startWidgets.size();
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            ConstraintWidget constraintWidget = startWidgets.get(i4);
            ConstraintAnchor[] constraintAnchorArr = constraintWidget.mListAnchors;
            int i5 = i2 + 1;
            i3 = Math.max(i3, getMaxDimensionTraversal(constraintWidget, i, constraintAnchorArr[i5].mTarget == null || !(constraintAnchorArr[i2].mTarget == null || constraintAnchorArr[i5].mTarget == null), 0));
        }
        constraintWidgetGroup.mGroupDimensions[i] = i3;
        return i3;
    }

    public static int getMaxDimensionTraversal(ConstraintWidget constraintWidget, int i, boolean z, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int width;
        int i9;
        int i10;
        int i11;
        ConstraintWidget constraintWidget2 = constraintWidget;
        int i12 = i;
        boolean z2 = z;
        int i13 = 0;
        if (!constraintWidget2.mOptimizerMeasurable) {
            return 0;
        }
        boolean z3 = constraintWidget2.mBaseline.mTarget != null && i12 == 1;
        if (z2) {
            i6 = constraintWidget.getBaselineDistance();
            i5 = constraintWidget.getHeight() - constraintWidget.getBaselineDistance();
            i4 = i12 * 2;
            i3 = i4 + 1;
        } else {
            i6 = constraintWidget.getHeight() - constraintWidget.getBaselineDistance();
            i5 = constraintWidget.getBaselineDistance();
            i3 = i12 * 2;
            i4 = i3 + 1;
        }
        ConstraintAnchor[] constraintAnchorArr = constraintWidget2.mListAnchors;
        if (constraintAnchorArr[i3].mTarget == null || constraintAnchorArr[i4].mTarget != null) {
            i7 = i3;
            i8 = 1;
        } else {
            i7 = i4;
            i4 = i3;
            i8 = -1;
        }
        int i14 = z3 ? i2 - i6 : i2;
        int parentBiasOffset = getParentBiasOffset(constraintWidget, i) + (constraintWidget2.mListAnchors[i4].getMargin() * i8);
        int i15 = i14 + parentBiasOffset;
        int width2 = (i12 == 0 ? constraintWidget.getWidth() : constraintWidget.getHeight()) * i8;
        Iterator<ResolutionNode> it = constraintWidget2.mListAnchors[i4].getResolutionNode().dependents.iterator();
        while (it.hasNext()) {
            i13 = Math.max(i13, getMaxDimensionTraversal(((ResolutionAnchor) it.next()).myAnchor.mOwner, i12, z2, i15));
        }
        int i16 = 0;
        for (Iterator<ResolutionNode> it2 = constraintWidget2.mListAnchors[i7].getResolutionNode().dependents.iterator(); it2.hasNext(); it2 = it2) {
            i16 = Math.max(i16, getMaxDimensionTraversal(((ResolutionAnchor) it2.next()).myAnchor.mOwner, i12, z2, width2 + i15));
        }
        if (z3) {
            i13 -= i6;
            width = i16 + i5;
        } else {
            width = i16 + ((i12 == 0 ? constraintWidget.getWidth() : constraintWidget.getHeight()) * i8);
        }
        int i17 = 1;
        if (i12 == 1) {
            Iterator<ResolutionNode> it3 = constraintWidget2.mBaseline.getResolutionNode().dependents.iterator();
            int i18 = 0;
            while (it3.hasNext()) {
                Iterator<ResolutionNode> it4 = it3;
                ResolutionAnchor resolutionAnchor = (ResolutionAnchor) it3.next();
                if (i8 == i17) {
                    i18 = Math.max(i18, getMaxDimensionTraversal(resolutionAnchor.myAnchor.mOwner, i12, z2, i6 + i15));
                    i11 = i7;
                } else {
                    i11 = i7;
                    i18 = Math.max(i18, getMaxDimensionTraversal(resolutionAnchor.myAnchor.mOwner, i12, z2, (i5 * i8) + i15));
                }
                it3 = it4;
                i7 = i11;
                i17 = 1;
            }
            i9 = i7;
            int i19 = i18;
            i10 = (constraintWidget2.mBaseline.getResolutionNode().dependents.size() <= 0 || z3) ? i19 : i8 == 1 ? i19 + i6 : i19 - i5;
        } else {
            i9 = i7;
            i10 = 0;
        }
        int max = Math.max(i13, Math.max(width, i10)) + parentBiasOffset;
        int i20 = i15 + width2;
        if (i8 != -1) {
            int i21 = i15;
            i15 = i20;
            i20 = i21;
        }
        if (z2) {
            Optimizer.setOptimizedWidget(constraintWidget2, i12, i20);
            constraintWidget2.setFrame(i20, i15, i12);
        } else {
            constraintWidget2.mBelongingGroup.addWidgetsToSet(constraintWidget2, i12);
            constraintWidget2.setRelativePositioning(i20, i12);
        }
        if (constraintWidget.getDimensionBehaviour(i) == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget2.mDimensionRatio != 0.0f) {
            constraintWidget2.mBelongingGroup.addWidgetsToSet(constraintWidget2, i12);
        }
        ConstraintAnchor[] constraintAnchorArr2 = constraintWidget2.mListAnchors;
        if (!(constraintAnchorArr2[i4].mTarget == null || constraintAnchorArr2[i9].mTarget == null)) {
            ConstraintWidget parent = constraintWidget.getParent();
            ConstraintAnchor[] constraintAnchorArr3 = constraintWidget2.mListAnchors;
            if (constraintAnchorArr3[i4].mTarget.mOwner == parent && constraintAnchorArr3[i9].mTarget.mOwner == parent) {
                constraintWidget2.mBelongingGroup.addWidgetsToSet(constraintWidget2, i12);
            }
        }
        return max;
    }

    public static int getParentBiasOffset(ConstraintWidget constraintWidget, int i) {
        ConstraintWidget constraintWidget2;
        ConstraintAnchor constraintAnchor;
        int i2 = i * 2;
        ConstraintAnchor[] constraintAnchorArr = constraintWidget.mListAnchors;
        ConstraintAnchor constraintAnchor2 = constraintAnchorArr[i2];
        ConstraintAnchor constraintAnchor3 = constraintAnchorArr[i2 + 1];
        ConstraintAnchor constraintAnchor4 = constraintAnchor2.mTarget;
        if (constraintAnchor4 == null || constraintAnchor4.mOwner != (constraintWidget2 = constraintWidget.mParent) || (constraintAnchor = constraintAnchor3.mTarget) == null || constraintAnchor.mOwner != constraintWidget2) {
            return 0;
        }
        return (int) (((float) (((constraintWidget2.getLength(i) - constraintAnchor2.getMargin()) - constraintAnchor3.getMargin()) - constraintWidget.getLength(i))) * (i == 0 ? constraintWidget.mHorizontalBiasPercent : constraintWidget.mVerticalBiasPercent));
    }

    public static void invalidate(ConstraintWidgetContainer constraintWidgetContainer, ConstraintWidget constraintWidget, ConstraintWidgetGroup constraintWidgetGroup) {
        constraintWidgetGroup.mSkipSolver = false;
        constraintWidgetContainer.mSkipSolver = false;
        constraintWidget.mOptimizerMeasurable = false;
    }

    public static int resolveDimensionRatio(ConstraintWidget constraintWidget) {
        float f;
        float f2;
        if (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            if (constraintWidget.mDimensionRatioSide == 0) {
                f2 = ((float) constraintWidget.getHeight()) * constraintWidget.mDimensionRatio;
            } else {
                f2 = ((float) constraintWidget.getHeight()) / constraintWidget.mDimensionRatio;
            }
            int i = (int) f2;
            constraintWidget.setWidth(i);
            return i;
        } else if (constraintWidget.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            return -1;
        } else {
            if (constraintWidget.mDimensionRatioSide == 1) {
                f = ((float) constraintWidget.getWidth()) * constraintWidget.mDimensionRatio;
            } else {
                f = ((float) constraintWidget.getWidth()) / constraintWidget.mDimensionRatio;
            }
            int i2 = (int) f;
            constraintWidget.setHeight(i2);
            return i2;
        }
    }

    public static void setConnection(ConstraintAnchor constraintAnchor) {
        ResolutionAnchor resolutionNode = constraintAnchor.getResolutionNode();
        ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
        if (constraintAnchor2 != null && constraintAnchor2.mTarget != constraintAnchor) {
            constraintAnchor2.getResolutionNode().addDependent(resolutionNode);
        }
    }

    public static void setPosition(List<ConstraintWidgetGroup> list, int i, int i2) {
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            for (ConstraintWidget next : list.get(i3).getWidgetsToSet(i)) {
                if (next.mOptimizerMeasurable) {
                    updateSizeDependentWidgets(next, i, i2);
                }
            }
        }
    }

    public static void singleGroup(ConstraintWidgetContainer constraintWidgetContainer) {
        constraintWidgetContainer.mWidgetGroups.clear();
        constraintWidgetContainer.mWidgetGroups.add(0, new ConstraintWidgetGroup(constraintWidgetContainer.mChildren));
    }

    public static boolean traverse(ConstraintWidget constraintWidget, ConstraintWidgetGroup constraintWidgetGroup, List<ConstraintWidgetGroup> list, boolean z) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        ConstraintAnchor constraintAnchor3;
        ConstraintWidget constraintWidget2;
        ConstraintAnchor constraintAnchor4;
        ConstraintAnchor constraintAnchor5;
        ConstraintAnchor constraintAnchor6;
        ConstraintAnchor constraintAnchor7;
        ConstraintWidget constraintWidget3;
        ConstraintAnchor constraintAnchor8;
        if (constraintWidget == null) {
            return true;
        }
        constraintWidget.mOptimizerMeasured = false;
        ConstraintWidgetContainer constraintWidgetContainer = (ConstraintWidgetContainer) constraintWidget.getParent();
        ConstraintWidgetGroup constraintWidgetGroup2 = constraintWidget.mBelongingGroup;
        if (constraintWidgetGroup2 == null) {
            constraintWidget.mOptimizerMeasurable = true;
            constraintWidgetGroup.mConstrainedGroup.add(constraintWidget);
            constraintWidget.mBelongingGroup = constraintWidgetGroup;
            if (constraintWidget.mLeft.mTarget == null && constraintWidget.mRight.mTarget == null && constraintWidget.mTop.mTarget == null && constraintWidget.mBottom.mTarget == null && constraintWidget.mBaseline.mTarget == null && constraintWidget.mCenter.mTarget == null) {
                constraintWidgetGroup.mSkipSolver = false;
                constraintWidgetContainer.mSkipSolver = false;
                constraintWidget.mOptimizerMeasurable = false;
                if (z) {
                    return false;
                }
            }
            if (!(constraintWidget.mTop.mTarget == null || constraintWidget.mBottom.mTarget == null)) {
                ConstraintWidget.DimensionBehaviour verticalDimensionBehaviour = constraintWidgetContainer.getVerticalDimensionBehaviour();
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                if (z) {
                    constraintWidgetGroup.mSkipSolver = false;
                    constraintWidgetContainer.mSkipSolver = false;
                    constraintWidget.mOptimizerMeasurable = false;
                    return false;
                } else if (!(constraintWidget.mTop.mTarget.mOwner == constraintWidget.getParent() && constraintWidget.mBottom.mTarget.mOwner == constraintWidget.getParent())) {
                    constraintWidgetGroup.mSkipSolver = false;
                    constraintWidgetContainer.mSkipSolver = false;
                    constraintWidget.mOptimizerMeasurable = false;
                }
            }
            if (!(constraintWidget.mLeft.mTarget == null || constraintWidget.mRight.mTarget == null)) {
                ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = constraintWidgetContainer.getHorizontalDimensionBehaviour();
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                if (z) {
                    constraintWidgetGroup.mSkipSolver = false;
                    constraintWidgetContainer.mSkipSolver = false;
                    constraintWidget.mOptimizerMeasurable = false;
                    return false;
                } else if (!(constraintWidget.mLeft.mTarget.mOwner == constraintWidget.getParent() && constraintWidget.mRight.mTarget.mOwner == constraintWidget.getParent())) {
                    constraintWidgetGroup.mSkipSolver = false;
                    constraintWidgetContainer.mSkipSolver = false;
                    constraintWidget.mOptimizerMeasurable = false;
                }
            }
            if (((constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) ^ (constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)) && constraintWidget.mDimensionRatio != 0.0f) {
                resolveDimensionRatio(constraintWidget);
            } else if (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                constraintWidgetGroup.mSkipSolver = false;
                constraintWidgetContainer.mSkipSolver = false;
                constraintWidget.mOptimizerMeasurable = false;
                if (z) {
                    return false;
                }
            }
            if (((constraintWidget.mLeft.mTarget == null && constraintWidget.mRight.mTarget == null) || (((constraintAnchor5 = constraintWidget.mLeft.mTarget) != null && constraintAnchor5.mOwner == constraintWidget.mParent && constraintWidget.mRight.mTarget == null) || (((constraintAnchor6 = constraintWidget.mRight.mTarget) != null && constraintAnchor6.mOwner == constraintWidget.mParent && constraintWidget.mLeft.mTarget == null) || ((constraintAnchor7 = constraintWidget.mLeft.mTarget) != null && constraintAnchor7.mOwner == (constraintWidget3 = constraintWidget.mParent) && (constraintAnchor8 = constraintWidget.mRight.mTarget) != null && constraintAnchor8.mOwner == constraintWidget3)))) && constraintWidget.mCenter.mTarget == null && !(constraintWidget instanceof Guideline) && !(constraintWidget instanceof Helper)) {
                constraintWidgetGroup.mStartHorizontalWidgets.add(constraintWidget);
            }
            if (((constraintWidget.mTop.mTarget == null && constraintWidget.mBottom.mTarget == null) || (((constraintAnchor = constraintWidget.mTop.mTarget) != null && constraintAnchor.mOwner == constraintWidget.mParent && constraintWidget.mBottom.mTarget == null) || (((constraintAnchor2 = constraintWidget.mBottom.mTarget) != null && constraintAnchor2.mOwner == constraintWidget.mParent && constraintWidget.mTop.mTarget == null) || ((constraintAnchor3 = constraintWidget.mTop.mTarget) != null && constraintAnchor3.mOwner == (constraintWidget2 = constraintWidget.mParent) && (constraintAnchor4 = constraintWidget.mBottom.mTarget) != null && constraintAnchor4.mOwner == constraintWidget2)))) && constraintWidget.mCenter.mTarget == null && constraintWidget.mBaseline.mTarget == null && !(constraintWidget instanceof Guideline) && !(constraintWidget instanceof Helper)) {
                constraintWidgetGroup.mStartVerticalWidgets.add(constraintWidget);
            }
            if (constraintWidget instanceof Helper) {
                constraintWidgetGroup.mSkipSolver = false;
                constraintWidgetContainer.mSkipSolver = false;
                constraintWidget.mOptimizerMeasurable = false;
                if (z) {
                    return false;
                }
                Helper helper = (Helper) constraintWidget;
                for (int i = 0; i < helper.mWidgetsCount; i++) {
                    if (!traverse(helper.mWidgets[i], constraintWidgetGroup, list, z)) {
                        return false;
                    }
                }
            }
            for (ConstraintAnchor constraintAnchor9 : constraintWidget.mListAnchors) {
                ConstraintAnchor constraintAnchor10 = constraintAnchor9.mTarget;
                if (!(constraintAnchor10 == null || constraintAnchor10.mOwner == constraintWidget.getParent())) {
                    if (constraintAnchor9.mType == ConstraintAnchor.Type.CENTER) {
                        constraintWidgetGroup.mSkipSolver = false;
                        constraintWidgetContainer.mSkipSolver = false;
                        constraintWidget.mOptimizerMeasurable = false;
                        if (z) {
                            return false;
                        }
                    } else {
                        setConnection(constraintAnchor9);
                    }
                    if (!traverse(constraintAnchor9.mTarget.mOwner, constraintWidgetGroup, list, z)) {
                        return false;
                    }
                }
            }
            return true;
        }
        if (constraintWidgetGroup2 != constraintWidgetGroup) {
            constraintWidgetGroup.mConstrainedGroup.addAll(constraintWidgetGroup2.mConstrainedGroup);
            constraintWidgetGroup.mStartHorizontalWidgets.addAll(constraintWidget.mBelongingGroup.mStartHorizontalWidgets);
            constraintWidgetGroup.mStartVerticalWidgets.addAll(constraintWidget.mBelongingGroup.mStartVerticalWidgets);
            if (!constraintWidget.mBelongingGroup.mSkipSolver) {
                constraintWidgetGroup.mSkipSolver = false;
            }
            list.remove(constraintWidget.mBelongingGroup);
            for (ConstraintWidget constraintWidget4 : constraintWidget.mBelongingGroup.mConstrainedGroup) {
                constraintWidget4.mBelongingGroup = constraintWidgetGroup;
            }
        }
        return true;
    }

    public static void updateSizeDependentWidgets(ConstraintWidget constraintWidget, int i, int i2) {
        int i3 = i * 2;
        ConstraintAnchor[] constraintAnchorArr = constraintWidget.mListAnchors;
        ConstraintAnchor constraintAnchor = constraintAnchorArr[i3];
        ConstraintAnchor constraintAnchor2 = constraintAnchorArr[i3 + 1];
        if ((constraintAnchor.mTarget == null || constraintAnchor2.mTarget == null) ? false : true) {
            Optimizer.setOptimizedWidget(constraintWidget, i, constraintAnchor.getMargin() + getParentBiasOffset(constraintWidget, i));
        } else if (constraintWidget.mDimensionRatio == 0.0f || constraintWidget.getDimensionBehaviour(i) != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            int relativePositioning = i2 - constraintWidget.getRelativePositioning(i);
            int length = relativePositioning - constraintWidget.getLength(i);
            constraintWidget.setFrame(length, relativePositioning, i);
            Optimizer.setOptimizedWidget(constraintWidget, i, length);
        } else {
            int resolveDimensionRatio = resolveDimensionRatio(constraintWidget);
            int i4 = (int) constraintWidget.mListAnchors[i3].getResolutionNode().resolvedOffset;
            constraintAnchor2.getResolutionNode().resolvedTarget = constraintAnchor.getResolutionNode();
            constraintAnchor2.getResolutionNode().resolvedOffset = (float) resolveDimensionRatio;
            constraintAnchor2.getResolutionNode().state = 1;
            constraintWidget.setFrame(i4, i4 + resolveDimensionRatio, i);
        }
    }

    public static boolean determineGroups(ConstraintWidget constraintWidget, List<ConstraintWidgetGroup> list, boolean z) {
        ConstraintWidgetGroup constraintWidgetGroup = new ConstraintWidgetGroup(new ArrayList(), true);
        list.add(constraintWidgetGroup);
        return traverse(constraintWidget, constraintWidgetGroup, list, z);
    }
}
