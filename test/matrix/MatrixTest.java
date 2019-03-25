package matrix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MatrixTest {

    @Test
    void shouldAssertThatTwoMatricesAreEqual() {
        Integer[][] matrixData = {{1, 2}, {3, 4}, {5, 6}};
        Matrix firstMatrix = new Matrix(matrixData);
        Matrix secondMatrix = new Matrix(matrixData);

        assertEquals(firstMatrix, secondMatrix);
    }

    @Test
    void shouldReturnAdditionOfTwoMatricesOfSameSize() {
        Integer[][] firstMatrixData = {{1, 2}, {3, 4}, {5, 6}};
        Integer[][] secondMatrixData = {{1, 1}, {1, 1}, {1, 1}};
        Integer[][] expectedMatrixData = {{2, 3}, {4, 5}, {6, 7}};

        Matrix firstMatrix = new Matrix(firstMatrixData);
        Matrix secondMatrix = new Matrix(secondMatrixData);
        Matrix expectedMatrix = new Matrix(expectedMatrixData);

        assertEquals(expectedMatrix, firstMatrix.add(secondMatrix));
    }

    @Test
    void shouldReturnSubtractionOfTwoMatricesOfSameSize() {
        Integer[][] firstMatrixData = {{1, 2}, {3, 4}, {5, 6}};
        Integer[][] secondMatrixData = {{1, 1}, {1, 1}, {1, 1}};
        Integer[][] expectedMatrixData = {{0, 1}, {2, 3}, {4, 5}};

        Matrix firstMatrix = new Matrix(firstMatrixData);
        Matrix secondMatrix = new Matrix(secondMatrixData);
        Matrix expectedMatrix = new Matrix(expectedMatrixData);

        assertEquals(expectedMatrix, firstMatrix.sub(secondMatrix));
    }

    @Test
    void shouldReturnMatrixMultipliedWithAGivenScalarQuantity() {
        Integer[][] matrixData = {{1, 2}, {3, 4}, {5, 6}};
        Integer[][] expectedMatrixData = {{-1, -2}, {-3, -4}, {-5, -6}};

        Matrix matrix = new Matrix(matrixData);
        Matrix expectedMatrix = new Matrix(expectedMatrixData);

        assertEquals(expectedMatrix, matrix.multiplyScalar(-1));
    }
}