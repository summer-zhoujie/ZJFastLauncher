package android.support.constraint.solver;

import android.support.constraint.solver.Pools;

public class Cache {
    public Pools.Pool<ArrayRow> arrayRowPool = new Pools.SimplePool(256);
    public SolverVariable[] mIndexedVariables = new SolverVariable[32];
    public Pools.Pool<SolverVariable> solverVariablePool = new Pools.SimplePool(256);
}
