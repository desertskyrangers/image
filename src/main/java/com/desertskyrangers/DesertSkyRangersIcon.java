package com.desertskyrangers;

import com.avereon.zerra.image.SvgIcon;

public class DesertSkyRangersIcon extends SvgIcon {

	@Override
	protected void doRender() {
		super.doRender();

		double a = 4 + 4 - Math.sqrt( 12 );
		double b = 4 + 4 + Math.sqrt( 12 );

		String sun = circle( 16, 16, 14 );
		String sunTopClip = "M0,0 L0,2 L6,2 L8,6 L13,5.5 A14,14,0,0,1,20,4 A10,10,0,0,1,25,5 L32,5 L32,0 Z";
		String sunLeftClip = "M0,12 L0,18 A3,3,0,0,1,4,15 L4,14 A4,4,0,0,1," + a + ",12 Z";
		String sunBottomClip = "M" + b + ",12 A4,4,0,0,1,12,14 L12,17 A3,3,0,0,1,16,20 A7,7,0,0,1,14,26  L32,26 L32,12 Z";
		String horizon = "M2,28 L2,30 L4,30 L4,28 Z M12,28 L12,30 L30,30 L30,28 Z";
		String cactus = "M6,30 L6,26  A6,6,0,0,1,2,20 L2,18 A1,1,0,0,1,4,18 L4,20 A3,3,0,0,0,6,23 L6,14 A2,2,0,0,1,10,14 L10,24 A3,3,0,0,0,12,21 L12,20 A1,1,0,0,1,14,20 A6,6,0,01,10,27  L10,30 Z";

		String plane = "M2,4 L2,10 L22,10 A6,1,0,0,0,28,9 A6,2,0,0,0,24,7 A8,8,0,0,0,20,6  A12,12,0,0,0,14,7.5 L7,8 L5,4 Z M23,9 A3,1,0,0,0,20,8 A13,13,0,0,0,15,9 Z";

		clip( sunTopClip );
		fill( sun );
		clip( null );

//		clip( sunLeftClip );
//		fill( sun );
//		clip( null );

		clip( sunBottomClip );
		fill( sun );
		clip( null );

		fill( horizon );

		fill( cactus );

		fill( plane );
	}

	public static void main( String[] commands ) {
		proof( new DesertSkyRangersIcon() );
	}

}
