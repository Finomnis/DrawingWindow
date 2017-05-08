package org.finomnis.common.graphics;

public enum ColorMap {

	GRAYSCALE(new float[]{0.0f, 0.0f, 0.0f,
						  1.0f, 1.0f, 1.0f}),
	JET(new float[]{
	         0f,         0f,    0.5000f,
	         0f,         0f,    1.0000f,
	         0f,    0.5000f,    1.0000f,
	         0f,    1.0000f,    1.0000f,
	    0.5000f,    1.0000f,    0.5000f,
	    1.0000f,    1.0000f,         0f,
	    1.0000f,    0.5000f,         0f,
	    1.0000f,         0f,         0f,
	    0.5000f,         0f,         0f
	}),
	PARULA(new float[]{
		    0.2081f,    0.1663f,    0.5292f,
		    0.2116f,    0.1898f,    0.5777f,
		    0.2123f,    0.2138f,    0.6270f,
		    0.2081f,    0.2386f,    0.6771f,
		    0.1959f,    0.2645f,    0.7279f,
		    0.1707f,    0.2919f,    0.7792f,
		    0.1253f,    0.3242f,    0.8303f,
		    0.0591f,    0.3598f,    0.8683f,
		    0.0117f,    0.3875f,    0.8820f,
		    0.0060f,    0.4086f,    0.8828f,
		    0.0165f,    0.4266f,    0.8786f,
		    0.0329f,    0.4430f,    0.8720f,
		    0.0498f,    0.4586f,    0.8641f,
		    0.0629f,    0.4737f,    0.8554f,
		    0.0723f,    0.4887f,    0.8467f,
		    0.0779f,    0.5040f,    0.8384f,
		    0.0793f,    0.5200f,    0.8312f,
		    0.0749f,    0.5375f,    0.8263f,
		    0.0641f,    0.5570f,    0.8240f,
		    0.0488f,    0.5772f,    0.8228f,
		    0.0343f,    0.5966f,    0.8199f,
		    0.0265f,    0.6137f,    0.8135f,
		    0.0239f,    0.6287f,    0.8038f,
		    0.0231f,    0.6418f,    0.7913f,
		    0.0228f,    0.6535f,    0.7768f,
		    0.0267f,    0.6642f,    0.7607f,
		    0.0384f,    0.6743f,    0.7436f,
		    0.0590f,    0.6838f,    0.7254f,
		    0.0843f,    0.6928f,    0.7062f,
		    0.1133f,    0.7015f,    0.6859f,
		    0.1453f,    0.7098f,    0.6646f,
		    0.1801f,    0.7177f,    0.6424f,
		    0.2178f,    0.7250f,    0.6193f,
		    0.2586f,    0.7317f,    0.5954f,
		    0.3022f,    0.7376f,    0.5712f,
		    0.3482f,    0.7424f,    0.5473f,
		    0.3953f,    0.7459f,    0.5244f,
		    0.4420f,    0.7481f,    0.5033f,
		    0.4871f,    0.7491f,    0.4840f,
		    0.5300f,    0.7491f,    0.4661f,
		    0.5709f,    0.7485f,    0.4494f,
		    0.6099f,    0.7473f,    0.4337f,
		    0.6473f,    0.7456f,    0.4188f,
		    0.6834f,    0.7435f,    0.4044f,
		    0.7184f,    0.7411f,    0.3905f,
		    0.7525f,    0.7384f,    0.3768f,
		    0.7858f,    0.7356f,    0.3633f,
		    0.8185f,    0.7327f,    0.3498f,
		    0.8507f,    0.7299f,    0.3360f,
		    0.8824f,    0.7274f,    0.3217f,
		    0.9139f,    0.7258f,    0.3063f,
		    0.9450f,    0.7261f,    0.2886f,
		    0.9739f,    0.7314f,    0.2666f,
		    0.9938f,    0.7455f,    0.2403f,
		    0.9990f,    0.7653f,    0.2164f,
		    0.9955f,    0.7861f,    0.1967f,
		    0.9880f,    0.8066f,    0.1794f,
		    0.9789f,    0.8271f,    0.1633f,
		    0.9697f,    0.8481f,    0.1475f,
		    0.9626f,    0.8705f,    0.1309f,
		    0.9589f,    0.8949f,    0.1132f,
		    0.9598f,    0.9218f,    0.0948f,
		    0.9661f,    0.9514f,    0.0755f,
		    0.9763f,    0.9831f,    0.0538f
	}),
	HOT(new float[]{
		    0f,              0f,         0f,
		    1.0000f,         0f,         0f,
		    1.0000f,    1.0000f,         0f,
		    1.0000f,    1.0000f,    1.0000f
	}),
	COOL(new float[]{
	        0f,         1.0000f,    1.0000f,
	        1.0000f,         0f,    1.0000f
	}),
	SPRING(new float[]{
			1.0000f,         0f,    1.0000f,
	        1.0000f,    1.0000f,         0f
	}),
	SUMMER(new float[]{

	        0f,         0.5000f,    0.4000f,
	        1.0000f,    1.0000f,    0.4000f
	}),
	AUTUMN(new float[]{

	        1.0000f,         0f,         0f,
	        1.0000f,    1.0000f,         0f
	}),
	WINTER(new float[]{

			     0f,         0f,    1.0000f,
	             0f,    1.0000f,    0.5000f
	});
	
	private final float[] map;
	ColorMap(float [] map){
		this.map = map;
	}
	
	private static float interpolate(float x, float x0, float x1, float val0, float val1){
		float val1_strength = (x-x0)/(x1-x0);
		float val0_strength = 1.0f - val1_strength;
		return val0 * val0_strength + val1 * val1_strength;
	}
	
	private float getInterpolated(float v, int col){
		if(v <= 0){
			return map[col];
		}
		if(v >= 1){
			return map[map.length - 3 + col];
		}
		int numSteps = map.length / 3 - 1;
		float bucket = (v*numSteps);
		int bucketID = (int)bucket;
		return interpolate(bucket, bucketID, bucketID+1, map[3*bucketID + col], map[3*(bucketID+1)+col]);
	}
	
	public float getR(float v){
		return getInterpolated(v, 0);
	}
	public float getG(float v){
		return getInterpolated(v, 1);
	}
	public float getB(float v){
		return getInterpolated(v, 2);
	}
		
}
