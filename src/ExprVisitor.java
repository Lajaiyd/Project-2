package src;

public interface ExprVisitor<R> {
    R plusExprVisit(PlusExpr expr);
    R minusExprVisit(MinusExpr expr);
    R timesExprVisit(TimesExpr expr);
    R divExprVisit(DivExpr expr);
    R floatExprVisit(FloatExpr expr);
}