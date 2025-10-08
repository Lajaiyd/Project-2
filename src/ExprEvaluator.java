package src;

public class ExprEvaluator implements ExprVisitor<Float> {

    @Override
    public Float plusExprVisit (PlusExpr expr) {
        return expr.getE1().accept(this) + expr.getE2().accept(this);
    }
    @Override
    public Float minusExprVisit(MinusExpr expr) {
        return expr.getE1().accept(this) - expr.getE2().accept(this);
    }
    @Override
    public Float timesExprVisit(TimesExpr expr) {
        return expr.getE1().accept(this) * expr.getE2().accept(this);
    }
    @Override
    public Float divExprVisit(DivExpr expr) {
        float eval2 = expr.getE2().accept(this);
        if (Float.compare(eval2, 0.0f) == 0){
            System.err.println ("Encountered Division by Zero");
            return Float.NaN;
        }
        return expr.getE1().accept(this)/ eval2;
    }
    @Override
    public Float floatExprVisit(FloatExpr expr){
        return expr.eval();
    }
}
