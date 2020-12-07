package android.support.constraint.solver;

import com.wpengapp.support.outline;
import java.util.ArrayList;

public class Metrics {
    public long additionalMeasures;
    public long barrierConnectionResolved;
    public long bfs;
    public long centerConnectionResolved;
    public long chainConnectionResolved;
    public long constraints;
    public long errors;
    public long extravariables;
    public long fullySolved;
    public long graphOptimizer;
    public long iterations;
    public long lastTableSize;
    public long matchConnectionResolved;
    public long maxRows;
    public long maxTableSize;
    public long maxVariables;
    public long measures;
    public long minimize;
    public long minimizeGoal;
    public long nonresolvedWidgets;
    public long oldresolvedWidgets;
    public long optimize;
    public long pivots;
    public ArrayList<String> problematicLayouts = new ArrayList<>();
    public long resolutions;
    public long resolvedWidgets;
    public long simpleconstraints;
    public long slackvariables;
    public long tableSizeIncrease;
    public long variables;

    public void reset() {
        this.measures = 0;
        this.additionalMeasures = 0;
        this.resolutions = 0;
        this.tableSizeIncrease = 0;
        this.maxTableSize = 0;
        this.lastTableSize = 0;
        this.maxVariables = 0;
        this.maxRows = 0;
        this.minimize = 0;
        this.minimizeGoal = 0;
        this.constraints = 0;
        this.simpleconstraints = 0;
        this.optimize = 0;
        this.iterations = 0;
        this.pivots = 0;
        this.bfs = 0;
        this.variables = 0;
        this.errors = 0;
        this.slackvariables = 0;
        this.extravariables = 0;
        this.fullySolved = 0;
        this.graphOptimizer = 0;
        this.resolvedWidgets = 0;
        this.oldresolvedWidgets = 0;
        this.nonresolvedWidgets = 0;
        this.centerConnectionResolved = 0;
        this.matchConnectionResolved = 0;
        this.chainConnectionResolved = 0;
        this.barrierConnectionResolved = 0;
        this.problematicLayouts.clear();
    }

    public String toString() {
        StringBuilder r0 = outline.m2549("\n*** Metrics ***\nmeasures: ");
        r0.append(this.measures);
        r0.append("\nadditionalMeasures: ");
        r0.append(this.additionalMeasures);
        r0.append("\nresolutions passes: ");
        r0.append(this.resolutions);
        r0.append("\ntable increases: ");
        r0.append(this.tableSizeIncrease);
        r0.append("\nmaxTableSize: ");
        r0.append(this.maxTableSize);
        r0.append("\nmaxVariables: ");
        r0.append(this.maxVariables);
        r0.append("\nmaxRows: ");
        r0.append(this.maxRows);
        r0.append("\n\nminimize: ");
        r0.append(this.minimize);
        r0.append("\nminimizeGoal: ");
        r0.append(this.minimizeGoal);
        r0.append("\nconstraints: ");
        r0.append(this.constraints);
        r0.append("\nsimpleconstraints: ");
        r0.append(this.simpleconstraints);
        r0.append("\noptimize: ");
        r0.append(this.optimize);
        r0.append("\niterations: ");
        r0.append(this.iterations);
        r0.append("\npivots: ");
        r0.append(this.pivots);
        r0.append("\nbfs: ");
        r0.append(this.bfs);
        r0.append("\nvariables: ");
        r0.append(this.variables);
        r0.append("\nerrors: ");
        r0.append(this.errors);
        r0.append("\nslackvariables: ");
        r0.append(this.slackvariables);
        r0.append("\nextravariables: ");
        r0.append(this.extravariables);
        r0.append("\nfullySolved: ");
        r0.append(this.fullySolved);
        r0.append("\ngraphOptimizer: ");
        r0.append(this.graphOptimizer);
        r0.append("\nresolvedWidgets: ");
        r0.append(this.resolvedWidgets);
        r0.append("\noldresolvedWidgets: ");
        r0.append(this.oldresolvedWidgets);
        r0.append("\nnonresolvedWidgets: ");
        r0.append(this.nonresolvedWidgets);
        r0.append("\ncenterConnectionResolved: ");
        r0.append(this.centerConnectionResolved);
        r0.append("\nmatchConnectionResolved: ");
        r0.append(this.matchConnectionResolved);
        r0.append("\nchainConnectionResolved: ");
        r0.append(this.chainConnectionResolved);
        r0.append("\nbarrierConnectionResolved: ");
        r0.append(this.barrierConnectionResolved);
        r0.append("\nproblematicsLayouts: ");
        return outline.m2546(r0, (Object) this.problematicLayouts, "\n");
    }
}
