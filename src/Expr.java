package src;

public abstract class Expr {

    abstract float eval();

    abstract <R> R accept(ExprVisitor<R> v);
}

abstract class BinaryExpr extends Expr {
    private final Expr e1;
    private final Expr e2;

    protected BinaryExpr(Expr e1, Expr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

    public Expr getE1() {
        return e1;
    }

    public Expr getE2() {
        return e2;
    }
}

class PlusExpr extends BinaryExpr {
    public PlusExpr(Expr e1, Expr e2) {
        super(e1, e2);
    }
    @Override
    public float eval()
    {
        return getE1().eval() + getE2().eval();
    }
    @Override
    public <R> R accept(ExprVisitor<R> v)
    {
        return v.plusExprVisit(this);
    }
}

class MinusExpr extends BinaryExpr {
    public MinusExpr(Expr e1, Expr e2) {
        super(e1, e2);
    }

    @Override
    public float eval()
    {
        return getE1().eval() - getE2().eval();
    }
    @Override
    public <R> R accept(ExprVisitor<R> v)
    {
        return v.minusExprVisit(this);
    }
}

class TimesExpr extends BinaryExpr {
    public TimesExpr(Expr e1, Expr e2) {
        super(e1, e2);
    }

    @Override
    public float eval()
    {
        return getE1().eval() * getE2().eval();
    }

    @Override
    public <R> R accept(ExprVisitor<R> v)
    {
        return v.timesExprVisit(this);
    }
}

class DivExpr extends BinaryExpr {
    public DivExpr(Expr e1, Expr e2) {
        super(e1, e2);
    }

    @Override
    public float eval()
    {
        float eval2 = getE2().eval();
        if (Float.compare(eval2, 0.0f) == 0){
            System.err.println ("Encountered Division by Zero");
            return Float.NaN;

        }
        return getE1().eval() /eval2;
    }

    @Override
    public <R> R accept(ExprVisitor<R> v)
    {
        return v.divExprVisit(this);
    }
}

class FloatExpr extends Expr {
    protected float literal;

    public FloatExpr(float literal){
        this.literal = literal;
    }

    @Override
    float eval() {
        return literal;
    }
    @Override
    <R> R accept(ExprVisitor<R> v){
        return v.floatExprVisit(this);
    }
}