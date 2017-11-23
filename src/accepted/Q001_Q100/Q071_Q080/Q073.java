package accepted.Q001_Q100.Q071_Q080;

public class Q073 {

	public void setZeroes(int[][] matrix) {
        int fi = -1;
        int fj = -1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    if (fi == -1) {
                        fi = i;
                        fj = j;
                    } else {
                        matrix[fi][j] = 0;
                        matrix[i][fj] = 0;
                    }
                } 
            }
        }
        
        if (fi == -1) {
            return;
        }
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i != fi && j != fj) {
                    if (matrix[fi][j] == 0 || matrix[i][fj] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }
        
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][fj] = 0;
        }
        for (int j = 0; j < matrix[fi].length; j++) {
            matrix[fi][j] = 0;
        }
    }
	
}
