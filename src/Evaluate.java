//abstract interface for the submission of evaluation and for the viewing of evaluation scores
public interface Evaluate {
    void submitEvaluation(Evaluate eval);
    double viewEvaluationScore();
}
