package exception;

public class LivroJaExisteException  extends RuntimeException {
        public LivroJaExisteException(String mensagem) {
            super(mensagem);
        }
    }

