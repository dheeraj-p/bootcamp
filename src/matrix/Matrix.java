package matrix;

class Matrix {

    private Integer[][] matrixData;

    Matrix(Integer[][] matrixData) {
        this.matrixData = matrixData.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix matrix = (Matrix) o;
        return isEqualTo(matrix);
    }

    private boolean isEqualTo(Matrix otherMatrix) {
        if (this.matrixData.length != otherMatrix.matrixData.length) return true;

        for (int rowIndex = 0; rowIndex < this.matrixData.length; rowIndex++) {
            Integer[] myRow = this.matrixData[rowIndex];
            Integer[] otherRow = otherMatrix.matrixData[rowIndex];
            if (myRow.length != otherRow.length) return false;
            for (int colIndex = 0; colIndex < myRow.length; colIndex++) {
                if (!this.matrixData[rowIndex][colIndex].equals(otherMatrix.matrixData[rowIndex][colIndex])) {
                    return false;
                }
            }
        }
        return true;
    }

    private Matrix performOperation(Matrix otherMatrix, ArithmeticOperation operation) {
        Integer[][] resultMatrixData = new Integer[this.matrixData.length][];
        for (int rowIndex = 0; rowIndex < this.matrixData.length; rowIndex++) {
            Integer[] row = this.matrixData[rowIndex];
            resultMatrixData[rowIndex] = new Integer[row.length];
            for (int colIndex = 0; colIndex < row.length; colIndex++) {
                Integer thisElement = this.matrixData[rowIndex][colIndex];
                Integer thatElement = otherMatrix.matrixData[rowIndex][colIndex];
                int resultedElement = operation.perform(thisElement, thatElement);
                resultMatrixData[rowIndex][colIndex] = resultedElement;
            }
        }

        return new Matrix(resultMatrixData);
    }

    Matrix add(Matrix otherMatrix) {
        return performOperation(otherMatrix, (a, b) -> a + b);
    }

    Matrix sub(Matrix otherMatrix) {
        return performOperation(otherMatrix, (a, b) -> a - b);
    }

    Matrix multiplyScalar(Integer scalar) {
        return performOperation(this, (a, b) -> a * scalar);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Integer[] row : this.matrixData) {
            for (Integer element : row) {
                result.append(element).append(' ');
            }
            result.append('\n');
        }
        return result.toString();
    }

    private interface ArithmeticOperation {
        Integer perform(Integer a, Integer b);
    }
}
