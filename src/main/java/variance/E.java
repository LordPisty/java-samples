package variance;

public class E extends D {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Covariant in return type
	@Override
	public G testVariance(G input) {
		return null;
	}
	
	// compiler error: NO contravariant parameters
	// @Override
	// public G testVariance(F input) {
	//	return null;
	// }
	// but ==> overloaded method
	public G testVariance(F input) {
		return null;
	}
}
