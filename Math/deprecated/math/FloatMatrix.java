package math;

import java.util.Arrays;
import java.util.Iterator;


public class FloatMatrix implements Iterable<Float> {
	
	public final int rows;
	public final int columns;
	
	protected final float[][] array;
	
	protected boolean determinantCalced;
	protected float determinant;
	
	
	public FloatMatrix(int rows, int columns) {
		// TODO Exception
		if (rows < 1) throw new IllegalArgumentException("");
		if (columns < 1) throw new IllegalArgumentException("");
		
		this.rows = rows;
		this.columns = columns;
		
		array = new float[rows][columns];
	}
	public FloatMatrix(double[]... matrix) {
		// TODO Exception
		this(matrix.length, matrix[0].length);
		
		for (int row = 0; row < rows; row++) {
			if (matrix[row].length != columns) throw new IllegalArgumentException("");
			
			for (int column = 0; column < columns; column++) {
				array[row][column] = (float) matrix[row][column];
			}
		}
	}
	public FloatMatrix(float[]... matrix) {
		// TODO Exception
		this(matrix.length, matrix[0].length);
		
		for (int row = 0; row < rows; row++) {
			if (matrix[row].length != columns) throw new IllegalArgumentException("");
			
			System.arraycopy(matrix[row], 0, array[row], 0, columns);
		}
	}
	public FloatMatrix(long[]... matrix) {
		// TODO Exception
		this(matrix.length, matrix[0].length);
		
		for (int row = 0; row < rows; row++) {
			if (matrix[row].length != columns) throw new IllegalArgumentException("");
			
			for (int column = 0; column < columns; column++) {
				array[row][column] = matrix[row][column];
			}
		}
	}
	public FloatMatrix(int[]... matrix) {
		// TODO Exception
		this(matrix.length, matrix[0].length);
		
		for (int row = 0; row < rows; row++) {
			if (matrix[row].length != columns) throw new IllegalArgumentException("");
			
			for (int column = 0; column < columns; column++) {
				array[row][column] = matrix[row][column];
			}
		}
	}
	public FloatMatrix(short[]... matrix) {
		// TODO Exception
		this(matrix.length, matrix[0].length);
		
		for (int row = 0; row < rows; row++) {
			if (matrix[row].length != columns) throw new IllegalArgumentException("");
			
			for (int column = 0; column < columns; column++) {
				array[row][column] = matrix[row][column];
			}
		}
	}
	public FloatMatrix(byte[]... matrix) {
		// TODO Exception
		this(matrix.length, matrix[0].length);
		
		for (int row = 0; row < rows; row++) {
			if (matrix[row].length != columns) throw new IllegalArgumentException("");
			
			for (int column = 0; column < columns; column++) {
				array[row][column] = matrix[row][column];
			}
		}
	}
	public FloatMatrix(DoubleMatrix matrix) {
		this(matrix.array);
	}
	public FloatMatrix(FloatMatrix matrix) {
		this(matrix.array);
	}
	public FloatMatrix(IntegerMatrix matrix) {
		this(matrix.array);
	}
	public FloatMatrix(ByteMatrix matrix) {
		this(matrix.array);
	}
	public FloatMatrix(boolean columnVector, DoubleVector... vectors) {
		// TODO Exception
		this(columnVector ? vectors[0].dimension : vectors.length,
				columnVector ? vectors.length : vectors[0].dimension);
		
		if (columnVector) {
			for (int column = 0; column < columns; column++) {
				if (vectors[column].dimension != rows) throw new IllegalArgumentException("");
				
				for (int row = 0; row < rows; row++) {
					array[row][column] = (float) vectors[column].array[row];
				}
			}
		} else {
			for (int row = 0; row < rows; row++) {
				if (vectors[row].dimension != columns) throw new IllegalArgumentException("");
				
				for (int column = 0; column < columns; column++) {
					array[row][column] = (float) vectors[row].array[column];
				}
			}
		}
	}
	public FloatMatrix(boolean columnVector, FloatVector... vectors) {
		// TODO Exception
		this(columnVector ? vectors[0].dimension : vectors.length,
				columnVector ? vectors.length : vectors[0].dimension);
		
		if (columnVector) {
			for (int column = 0; column < columns; column++) {
				if (vectors[column].dimension != rows) throw new IllegalArgumentException("");
				
				for (int row = 0; row < rows; row++) {
					array[row][column] = vectors[column].array[row];
				}
			}
		} else {
			for (int row = 0; row < rows; row++) {
				if (vectors[row].dimension != columns) throw new IllegalArgumentException("");
				
				System.arraycopy(vectors[row].array, 0, array[row], 0, columns);
			}
		}
	}
	public FloatMatrix(boolean columnVector, IntegerVector... vectors) {
		// TODO Exception
		this(columnVector ? vectors[0].dimension : vectors.length,
				columnVector ? vectors.length : vectors[0].dimension);
		
		if (columnVector) {
			for (int column = 0; column < columns; column++) {
				if (vectors[column].dimension != rows) throw new IllegalArgumentException("");
				
				for (int row = 0; row < rows; row++) {
					array[row][column] = vectors[column].array[row];
				}
			}
		} else {
			for (int row = 0; row < rows; row++) {
				if (vectors[row].dimension != columns) throw new IllegalArgumentException("");
				
				for (int column = 0; column < columns; column++) {
					array[row][column] = vectors[row].array[column];
				}
			}
		}
	}
	public FloatMatrix(boolean columnVector, ByteVector... vectors) {
		// TODO Exception
		this(columnVector ? vectors[0].dimension : vectors.length,
				columnVector ? vectors.length : vectors[0].dimension);
		
		if (columnVector) {
			for (int column = 0; column < columns; column++) {
				if (vectors[column].dimension != rows) throw new IllegalArgumentException("");
				
				for (int row = 0; row < rows; row++) {
					array[row][column] = vectors[column].array[row];
				}
			}
		} else {
			for (int row = 0; row < rows; row++) {
				if (vectors[row].dimension != columns) throw new IllegalArgumentException("");
				
				for (int column = 0; column < columns; column++) {
					array[row][column] = vectors[row].array[column];
				}
			}
		}
	}
	
	
	public String toString() {
		String result = "";
		
		for (int row = 0; row < rows; row++) {
			result += Arrays.toString(array[row]);
			if (row < rows - 1) result += System.getProperty("line.separator");
		}
		
		return result;
	}
	public boolean equals(Object obj) {
		if (!super.equals(obj)) return false;
		if (!(obj instanceof FloatMatrix)) return false;
		
		FloatMatrix matrix = (FloatMatrix) obj;
		
		if (rows != matrix.rows) return false;
		if (columns != matrix.columns) return false;
		
		for (int row = 0; row < rows; row++) {
			if (!Arrays.equals(array[row], matrix.array[row])) return false;
		}
		
		return true;
	}
	public int hashCode() {
		return Arrays.hashCode(array);
	}
	
	
	public float component(int row, int column) {
		return array[row][column];
	}
	public Iterator<Float> iterator() {
		return new DefaultIterator();
	}
	public DoubleMatrix asDoubleMatrix() {
		return new DoubleMatrix(this);
	}
	public IntegerMatrix asIntegerMatrix() {
		return new IntegerMatrix(this);
	}
	public ByteMatrix asByteMatrix() {
		return new ByteMatrix(this);
	}
	
	public DoubleMatrix setComponent(int row, int column, double value) {
		DoubleMatrix result = new DoubleMatrix(this);
		
		result.array[row][column] = value;
		
		return result;
	}
	public FloatMatrix setComponent(int row, int column, float value) {
		FloatMatrix result = new FloatMatrix(this);
		
		result.array[row][column] = value;
		
		return result;
	}
	
	
	public float determinant() {
		// TODO Exception
		if (rows != columns) throw new IllegalArgumentException();
		
		if (determinantCalced) return determinant;
		
		if (rows == 1) return array[0][0];
		if (rows == 2) return determinant2D();
		if (rows == 3) return determinant3D();
		
		float result = 0;
		float tmp;
		
		for (int row = 0; row < rows; row++) {
			if (array[row][0] == 0f) continue;
			tmp = array[row][0] * strikeRowColumn(row, 0).determinant();
			
			if ((row & 1) == 0) result += tmp;
			else result -= tmp;
		}
		
		return determinant = result;
	}
	private float determinant2D() {
		return	array[0][0] * array[1][1] -
				array[1][0] * array[0][1];
	}
	private float determinant3D() {
		return	array[0][0] * array[1][1] * array[2][2] +
				array[1][0] * array[2][1] * array[0][2] +
				array[2][0] * array[0][1] * array[1][2] -
				array[2][0] * array[1][1] * array[0][2] -
				array[1][0] * array[0][1] * array[2][2] -
				array[0][0] * array[2][1] * array[1][2];
	}
	public FloatMatrix invert() {
		FloatMatrix result = new FloatMatrix(rows, columns);
		
		for (int row = 0; row < rows; row++) {
			for (int column = 0; column < columns; column++) {
				result.array[row][column] = -array[row][column];
			}
		}
		
		return result;
	}
	public FloatMatrix transpose() {
		FloatMatrix result = new FloatMatrix(columns, rows);
		
		for (int row = 0; row < rows; row++) {
			for (int column = 0; column < columns; column++) {
				result.array[column][row] = array[row][column];
			}
		}
		
		return result;
	}
	
	public DoubleMatrix add(DoubleMatrix summand) {
		// TODO Exception
		if (rows != summand.rows) throw new IllegalArgumentException("");
		if (columns != summand.columns) throw new IllegalArgumentException("");
		
		DoubleMatrix result = new DoubleMatrix(rows, columns);
		
		for (int row = 0; row < rows; row++) {
			for (int column = 0; column < columns; column++) {
				result.array[row][column] = array[row][column] + summand.array[row][column];
			}
		}
		
		return result;
	}
	public FloatMatrix add(FloatMatrix summand) {
		// TODO Exception
		if (rows != summand.rows) throw new IllegalArgumentException("");
		if (columns != summand.columns) throw new IllegalArgumentException("");
		
		FloatMatrix result = new FloatMatrix(rows, columns);
		
		for (int row = 0; row < rows; row++) {
			for (int column = 0; column < columns; column++) {
				result.array[row][column] = array[row][column] + summand.array[row][column];
			}
		}
		
		return result;
	}
	public FloatMatrix add(IntegerMatrix summand) {
		// TODO Exception
		if (rows != summand.rows) throw new IllegalArgumentException("");
		if (columns != summand.columns) throw new IllegalArgumentException("");
		
		FloatMatrix result = new FloatMatrix(rows, columns);
		
		for (int row = 0; row < rows; row++) {
			for (int column = 0; column < columns; column++) {
				result.array[row][column] = array[row][column] + summand.array[row][column];
			}
		}
		
		return result;
	}
	public FloatMatrix add(ByteMatrix summand) {
		// TODO Exception
		if (rows != summand.rows) throw new IllegalArgumentException("");
		if (columns != summand.columns) throw new IllegalArgumentException("");
		
		FloatMatrix result = new FloatMatrix(rows, columns);
		
		for (int row = 0; row < rows; row++) {
			for (int column = 0; column < columns; column++) {
				result.array[row][column] = array[row][column] + summand.array[row][column];
			}
		}
		
		return result;
	}
	public DoubleMatrix subtract(DoubleMatrix subtrahend) {
		// TODO Exception
		if (rows != subtrahend.rows) throw new IllegalArgumentException("");
		if (columns != subtrahend.columns) throw new IllegalArgumentException("");
		
		DoubleMatrix result = new DoubleMatrix(rows, columns);
		
		for (int row = 0; row < rows; row++) {
			for (int column = 0; column < columns; column++) {
				result.array[row][column] = array[row][column] - subtrahend.array[row][column];
			}
		}
		
		return result;
	}
	public FloatMatrix subtract(FloatMatrix subtrahend) {
		// TODO Exception
		if (rows != subtrahend.rows) throw new IllegalArgumentException("");
		if (columns != subtrahend.columns) throw new IllegalArgumentException("");
		
		FloatMatrix result = new FloatMatrix(rows, columns);
		
		for (int row = 0; row < rows; row++) {
			for (int column = 0; column < columns; column++) {
				result.array[row][column] = array[row][column] - subtrahend.array[row][column];
			}
		}
		
		return result;
	}
	public FloatMatrix subtract(ByteMatrix subtrahend) {
		// TODO Exception
		if (rows != subtrahend.rows) throw new IllegalArgumentException("");
		if (columns != subtrahend.columns) throw new IllegalArgumentException("");
		
		FloatMatrix result = new FloatMatrix(rows, columns);
		
		for (int row = 0; row < rows; row++) {
			for (int column = 0; column < columns; column++) {
				result.array[row][column] = array[row][column] - subtrahend.array[row][column];
			}
		}
		
		return result;
	}
	public DoubleMatrix scalarMultiply(double factor) {
		DoubleMatrix result = new DoubleMatrix(rows, columns);
		
		for (int row = 0; row < rows; row++) {
			for (int column = 0; column < columns; column++) {
				result.array[row][column] = array[row][column] * factor;
			}
		}
		
		return result;
	}
	public FloatMatrix scalarMultiply(float factor) {
		FloatMatrix result = new FloatMatrix(rows, columns);
		
		for (int row = 0; row < rows; row++) {
			for (int column = 0; column < columns; column++) {
				result.array[row][column] = array[row][column] * factor;
			}
		}
		
		return result;
	}
	public DoubleMatrix scalarDivide(double divisor) {
		return scalarMultiply(1d / divisor);
	}
	public FloatMatrix scalarDivide(float divisor) {
		return scalarMultiply(1f / divisor);
	}
	
	public FloatMatrix strikeRow(int row) {
		// TODO Exception
		if ((row < 0) || (row >= rows)) throw new IllegalArgumentException("");
		if (rows == 1) throw new IllegalArgumentException("");
		
		FloatMatrix result = new FloatMatrix(rows - 1, columns);
		
		int offsetRow = 0;
		
		for (int newRow = 0; newRow < result.rows; newRow++) {
			if (newRow == row) offsetRow++;
			
			result.array[newRow] = array[newRow + offsetRow];
		}
		
		return result;
	}
	public FloatMatrix strikeColumn(int column) {
		// TODO Exception
		if ((column < 0) || (column >= columns)) throw new IllegalArgumentException("");
		if (columns == 1) throw new IllegalArgumentException("");
		
		FloatMatrix result = new FloatMatrix(rows, columns - 1);
		
		int offsetColumn = 0;
		
		for (int row = 0; row < rows; row++) {
			offsetColumn = 0;
			
			for (int newColumn = 0; newColumn < result.columns; newColumn++) {
				if (newColumn == column) offsetColumn++;
				
				result.array[row][newColumn] = array[row][newColumn + offsetColumn];
			}
		}
		
		return result;
	}
	public FloatMatrix strikeRowColumn(int row, int column) {
		// TODO Exception
		if ((row < 0) || (row >= rows)) throw new IllegalArgumentException("");
		if (rows == 1) throw new IllegalArgumentException("");
		if ((column < 0) || (column >= columns)) throw new IllegalArgumentException("");
		if (columns == 1) throw new IllegalArgumentException("");
		
		FloatMatrix result = new FloatMatrix(rows - 1, columns - 1);
		
		int offsetRow = 0;
		int offsetColumn = 0;
		
		for (int newRow = 0; newRow < result.rows; newRow++) {
			if (newRow == row) offsetRow++;
			
			offsetColumn = 0;
			
			for (int newColumn = 0; newColumn < result.columns; newColumn++) {
				if (newColumn == column) offsetColumn++;
				
				result.array[newRow][newColumn] = array[newRow + offsetRow][newColumn + offsetColumn];
			}
		}
		
		return result;
	}
	
	public DoubleMatrix matrixMultiply(DoubleMatrix multiplicand) {
		// TODO Exception
		if (columns != multiplicand.rows) throw new IllegalArgumentException("");
		
		DoubleMatrix result = new DoubleMatrix(rows, multiplicand.columns);
		
		for (int row = 0; row < result.rows; row++) {
			for (int column = 0; column < result.columns; column++) {
				for (int k = 0; k < columns; k++) {
					result.array[row][column] += array[row][k] * multiplicand.array[k][column];
				}
			}
		}
		
		return result;
	}
	public FloatMatrix matrixMultiply(FloatMatrix multiplicand) {
		// TODO Exception
		if (columns != multiplicand.rows) throw new IllegalArgumentException("");
		
		FloatMatrix result = new FloatMatrix(rows, multiplicand.columns);
		
		for (int row = 0; row < result.rows; row++) {
			for (int column = 0; column < result.columns; column++) {
				for (int k = 0; k < columns; k++) {
					result.array[row][column] += array[row][k] * multiplicand.array[k][column];
				}
			}
		}
		
		return result;
	}
	public FloatMatrix matrixMultiply(IntegerMatrix multiplicand) {
		// TODO Exception
		if (columns != multiplicand.rows) throw new IllegalArgumentException("");
		
		FloatMatrix result = new FloatMatrix(rows, multiplicand.columns);
		
		for (int row = 0; row < result.rows; row++) {
			for (int column = 0; column < result.columns; column++) {
				for (int k = 0; k < columns; k++) {
					result.array[row][column] += array[row][k] * multiplicand.array[k][column];
				}
			}
		}
		
		return result;
	}
	public FloatMatrix matrixMultiply(ByteMatrix multiplicand) {
		// TODO Exception
		if (columns != multiplicand.rows) throw new IllegalArgumentException("");
		
		FloatMatrix result = new FloatMatrix(rows, multiplicand.columns);
		
		for (int row = 0; row < result.rows; row++) {
			for (int column = 0; column < result.columns; column++) {
				for (int k = 0; k < columns; k++) {
					result.array[row][column] += array[row][k] * multiplicand.array[k][column];
				}
			}
		}
		
		return result;
	}
	public DoubleVector matrixMultiply(DoubleVector multiplicand) {
		// TODO Exception
		if (columns != multiplicand.dimension) throw new IllegalArgumentException("");
		
		DoubleVector result = new DoubleVector(rows);
		
		for (int row = 0; row < rows; row++) {
			for (int column = 0; column < columns; column++) {
				result.array[row] += array[row][column] * multiplicand.array[column];
			}
		}
		
		return result;
	}
	public FloatVector matrixMultiply(FloatVector multiplicand) {
		// TODO Exception
		if (columns != multiplicand.dimension) throw new IllegalArgumentException("");
		
		FloatVector result = new FloatVector(rows);
		
		for (int row = 0; row < rows; row++) {
			for (int column = 0; column < columns; column++) {
				result.array[row] += array[row][column] * multiplicand.array[column];
			}
		}
		
		return result;
	}
	public FloatVector matrixMultiply(IntegerVector multiplicand) {
		// TODO Exception
		if (columns != multiplicand.dimension) throw new IllegalArgumentException("");
		
		FloatVector result = new FloatVector(rows);
		
		for (int row = 0; row < rows; row++) {
			for (int column = 0; column < columns; column++) {
				result.array[row] += array[row][column] * multiplicand.array[column];
			}
		}
		
		return result;
	}
	public FloatVector matrixMultiply(ByteVector multiplicand) {
		// TODO Exception
		if (columns != multiplicand.dimension) throw new IllegalArgumentException("");
		
		FloatVector result = new FloatVector(rows);
		
		for (int row = 0; row < rows; row++) {
			for (int column = 0; column < columns; column++) {
				result.array[row] += array[row][column] * multiplicand.array[column];
			}
		}
		
		return result;
	}
	
	
	private class DefaultIterator implements Iterator<Float> {
		private final int lastElement;
		private int element;
		
		public DefaultIterator() {
			lastElement = rows * columns;
		}
		
		public boolean hasNext() {
			return element < lastElement;
		}
		public Float next() {
			return array[element / columns][element++ % columns];
		}
		public void remove() {
			throw new RuntimeException("Opperation not supported!");
		}
	}
	
}