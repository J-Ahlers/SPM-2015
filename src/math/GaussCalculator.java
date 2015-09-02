package math;


public class GaussCalculator {

	public GaussEquation solve(GaussEquation a, GaussEquation b, GaussEquation c, GaussEquation d) {
		// ++++++++++++++++++++++++++++
		// First Parameter Elimination
		// ++++++++++++++++++++++++++++
		
		// Step 1
		GaussEquation a1 = a.clone();
		a1.multiply(b.getX0() / a.getX0());
		
		// Step 2
		GaussEquation b1 = b.clone();
		b1.substract(a1);
		
		// Step 3
		GaussEquation a2 = a.clone();
		a2.multiply(c.getX0() / a.getX0());
		
		// Step 4
		GaussEquation c1 = c.clone();
		c1.substract(a2);
		
		// Step 5
		GaussEquation a3 = a.clone();
		a3.multiply(d.getX0() / a.getX0());
		
		// Step 6
		GaussEquation d1 = d.clone();
		d1.substract(a3);
		
		/* Step 7
		*
		* New equation objects:
		*
		* b1 : X0 = 0
		* c1 : X0 = 0
		* d1 : X0 = 0
		*
		*/
		GaussEquation e = b1;
		GaussEquation f = c1;
		GaussEquation g = d1;
		
		// ++++++++++++++++++++++++++++
		// Second Parameter Elimination
		// ++++++++++++++++++++++++++++
		
		// Step 1
		GaussEquation e1 = e.clone();
		e1.multiply(f.getX1() / e.getX1());
		
		// Step 2
		GaussEquation f1 = f.clone();
		f1.substract(e1);
		
		// Step 3
		GaussEquation e2 = e.clone();
		e2.multiply(g.getX1() / e.getX1());
		
		// Step 4
		GaussEquation g1 = g.clone();
		g1.substract(e2);
		
		/* Step 5
		*
		* New equation objects:
		*
		* f1 : X1 = 0
		* g1 : X1 = 0
		*
		*/
		
		GaussEquation h = f1;
		GaussEquation i = g1;
		
		// ++++++++++++++++++++++++++++
		// Third Parameter Elimination
		// ++++++++++++++++++++++++++++
		
		// Step 1
		GaussEquation h1 = h.clone();
		h1.multiply(i.getX2() / h.getX2());
		
		// Step 2
		GaussEquation i1 = i.clone();
		i1.substract(h1);
		
		/* Step 3
		*
		* New equation objects:
		*
		* i1 : X2 = 0
		*
		*/
		
		GaussEquation j = i1;
		
		// ++++++++++++++++++++++++++++
		// Solve for the Parameters
		// ++++++++++++++++++++++++++++
		
		// Step 2
		float solution_b3 = 0;
		if(java.lang.Math.abs(j.getX3()) > 0.0001) {
			solution_b3 = j.getX4() / j.getX3();
		}
		
		// Step 3
		a.setB3(solution_b3);
		e.setB3(solution_b3);
		h.setB3(solution_b3);
		
		// Step 4
		float solution_b2 = (h.getX4() - h.get3()) / h.getX2();
		
		// Step 5
		a.setB2(solution_b2);
		e.setB2(solution_b2);
		
		// Step 6
		float solution_b1 = (e.getX4() - e.get3() - e.get2()) / e.getX1();
		
		// Step 7
		a.setB1(solution_b1);
		
		// Step 8
		float solution_b0 = (a.getX4() - a.get3() - a.get2() - a.get1()) / a.getX0();
		
		GaussEquation solution = new GaussEquation(solution_b0, solution_b1, solution_b2, solution_b3);
		return solution;
	}
}
