package android.support.constraint.solver;

import android.support.p000v4.text.BidiFormatter;
import com.wpengapp.support.outline;
import java.util.Arrays;

public class SolverVariable {
    public static final boolean INTERNAL_DEBUG = false;
    public static final int MAX_STRENGTH = 7;
    public static final int STRENGTH_BARRIER = 7;
    public static final int STRENGTH_EQUALITY = 5;
    public static final int STRENGTH_FIXED = 6;
    public static final int STRENGTH_HIGH = 3;
    public static final int STRENGTH_HIGHEST = 4;
    public static final int STRENGTH_LOW = 1;
    public static final int STRENGTH_MEDIUM = 2;
    public static final int STRENGTH_NONE = 0;
    public static int uniqueConstantId = 1;
    public static int uniqueErrorId = 1;
    public static int uniqueId = 1;
    public static int uniqueSlackId = 1;
    public static int uniqueUnrestrictedId = 1;
    public float computedValue;
    public int definitionId = -1;

    /* renamed from: id */
    public int f14id = -1;
    public ArrayRow[] mClientEquations = new ArrayRow[8];
    public int mClientEquationsCount = 0;
    public String mName;
    public Type mType;
    public int strength = 0;
    public float[] strengthVector = new float[7];
    public int usageInRowCount = 0;

    /* renamed from: android.support.constraint.solver.SolverVariable$1 */
    static /* synthetic */ class C00091 {
        public static final /* synthetic */ int[] $SwitchMap$android$support$constraint$solver$SolverVariable$Type = new int[Type.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            /*
                android.support.constraint.solver.SolverVariable$Type[] r0 = android.support.constraint.solver.SolverVariable.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$android$support$constraint$solver$SolverVariable$Type = r0
                int[] r0 = $SwitchMap$android$support$constraint$solver$SolverVariable$Type     // Catch:{ NoSuchFieldError -> 0x0014 }
                android.support.constraint.solver.SolverVariable$Type r1 = android.support.constraint.solver.SolverVariable.Type.UNRESTRICTED     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = $SwitchMap$android$support$constraint$solver$SolverVariable$Type     // Catch:{ NoSuchFieldError -> 0x001f }
                android.support.constraint.solver.SolverVariable$Type r1 = android.support.constraint.solver.SolverVariable.Type.CONSTANT     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = $SwitchMap$android$support$constraint$solver$SolverVariable$Type     // Catch:{ NoSuchFieldError -> 0x002a }
                android.support.constraint.solver.SolverVariable$Type r1 = android.support.constraint.solver.SolverVariable.Type.SLACK     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = $SwitchMap$android$support$constraint$solver$SolverVariable$Type     // Catch:{ NoSuchFieldError -> 0x0035 }
                android.support.constraint.solver.SolverVariable$Type r1 = android.support.constraint.solver.SolverVariable.Type.ERROR     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                int[] r0 = $SwitchMap$android$support$constraint$solver$SolverVariable$Type     // Catch:{ NoSuchFieldError -> 0x0040 }
                android.support.constraint.solver.SolverVariable$Type r1 = android.support.constraint.solver.SolverVariable.Type.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x0040 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0040 }
            L_0x0040:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.solver.SolverVariable.C00091.<clinit>():void");
        }
    }

    public enum Type {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public SolverVariable(String str, Type type) {
        this.mName = str;
        this.mType = type;
    }

    public static String getUniqueName(Type type, String str) {
        if (str != null) {
            StringBuilder r2 = outline.m2549(str);
            r2.append(uniqueErrorId);
            return r2.toString();
        }
        int ordinal = type.ordinal();
        if (ordinal == 0) {
            StringBuilder r22 = outline.m2549("U");
            int i = uniqueUnrestrictedId + 1;
            uniqueUnrestrictedId = i;
            r22.append(i);
            return r22.toString();
        } else if (ordinal == 1) {
            StringBuilder r23 = outline.m2549("C");
            int i2 = uniqueConstantId + 1;
            uniqueConstantId = i2;
            r23.append(i2);
            return r23.toString();
        } else if (ordinal == 2) {
            StringBuilder r24 = outline.m2549("S");
            int i3 = uniqueSlackId + 1;
            uniqueSlackId = i3;
            r24.append(i3);
            return r24.toString();
        } else if (ordinal == 3) {
            StringBuilder r25 = outline.m2549("e");
            int i4 = uniqueErrorId + 1;
            uniqueErrorId = i4;
            r25.append(i4);
            return r25.toString();
        } else if (ordinal == 4) {
            StringBuilder r26 = outline.m2549("V");
            int i5 = uniqueId + 1;
            uniqueId = i5;
            r26.append(i5);
            return r26.toString();
        } else {
            throw new AssertionError(type.name());
        }
    }

    public static void increaseErrorId() {
        uniqueErrorId++;
    }

    public final void addToRow(ArrayRow arrayRow) {
        int i = 0;
        while (true) {
            int i2 = this.mClientEquationsCount;
            if (i >= i2) {
                ArrayRow[] arrayRowArr = this.mClientEquations;
                if (i2 >= arrayRowArr.length) {
                    this.mClientEquations = (ArrayRow[]) Arrays.copyOf(arrayRowArr, arrayRowArr.length * 2);
                }
                ArrayRow[] arrayRowArr2 = this.mClientEquations;
                int i3 = this.mClientEquationsCount;
                arrayRowArr2[i3] = arrayRow;
                this.mClientEquationsCount = i3 + 1;
                return;
            } else if (this.mClientEquations[i] != arrayRow) {
                i++;
            } else {
                return;
            }
        }
    }

    public void clearStrengths() {
        for (int i = 0; i < 7; i++) {
            this.strengthVector[i] = 0.0f;
        }
    }

    public String getName() {
        return this.mName;
    }

    public final void removeFromRow(ArrayRow arrayRow) {
        int i = this.mClientEquationsCount;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.mClientEquations[i2] == arrayRow) {
                for (int i3 = 0; i3 < (i - i2) - 1; i3++) {
                    ArrayRow[] arrayRowArr = this.mClientEquations;
                    int i4 = i2 + i3;
                    arrayRowArr[i4] = arrayRowArr[i4 + 1];
                }
                this.mClientEquationsCount--;
                return;
            }
        }
    }

    public void reset() {
        this.mName = null;
        this.mType = Type.UNKNOWN;
        this.strength = 0;
        this.f14id = -1;
        this.definitionId = -1;
        this.computedValue = 0.0f;
        this.mClientEquationsCount = 0;
        this.usageInRowCount = 0;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void setType(Type type, String str) {
        this.mType = type;
    }

    public String strengthsToString() {
        String str = this + "[";
        boolean z = false;
        boolean z2 = true;
        for (int i = 0; i < this.strengthVector.length; i++) {
            StringBuilder r0 = outline.m2549(str);
            r0.append(this.strengthVector[i]);
            String sb = r0.toString();
            float[] fArr = this.strengthVector;
            if (fArr[i] > 0.0f) {
                z = false;
            } else if (fArr[i] < 0.0f) {
                z = true;
            }
            if (this.strengthVector[i] != 0.0f) {
                z2 = false;
            }
            if (i < this.strengthVector.length - 1) {
                str = outline.m2556(sb, ", ");
            } else {
                str = outline.m2556(sb, "] ");
            }
        }
        if (z) {
            str = outline.m2556(str, " (-)");
        }
        return z2 ? outline.m2556(str, " (*)") : str;
    }

    public String toString() {
        StringBuilder r0 = outline.m2549(BidiFormatter.EMPTY_STRING);
        r0.append(this.mName);
        return r0.toString();
    }

    public final void updateReferencesWithNewDefinition(ArrayRow arrayRow) {
        int i = this.mClientEquationsCount;
        for (int i2 = 0; i2 < i; i2++) {
            ArrayRow[] arrayRowArr = this.mClientEquations;
            arrayRowArr[i2].variables.updateFromRow(arrayRowArr[i2], arrayRow, false);
        }
        this.mClientEquationsCount = 0;
    }

    public SolverVariable(Type type, String str) {
        this.mType = type;
    }
}
