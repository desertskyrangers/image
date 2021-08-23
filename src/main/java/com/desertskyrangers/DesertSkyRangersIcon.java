package com.desertskyrangers;

import com.avereon.zerra.image.SvgIcon;

public class DesertSkyRangersIcon extends SvgIcon {

	@Override
	protected void doRender() {
		super.doRender();

		String sun = circle( 16, 16, 14 );
		String sunClip = "M0,0 L0,16 L2,16  A3,3,0,0,1,6,13 L6,12 A4,4,0,0,1,14,12 L14,15 A3,3,0,0,1,18,18 A7,7,0,0,1,16,24  L32,24 L32,0 Z";

		String horizon = "M0,26 L0,32 L32,32 L32,26 L14,26 L14,28 L6,28 L6,26 Z";

		String cactus = "M8,28 L8,24  A6,6,0,0,1,4,18 L4,16 A1,1,0,0,1,6,16 L6,18 A3,3,0,0,0,8,21 L8,12 A2,2,0,0,1,12,12 L12,22 A3,3,0,0,0,14,19 L14,18 A1,1,0,0,1,16,18 A6,6,0,01,12,25  L12,28 Z";

		clip( sunClip );
		fill( sun );
		clip( null );

		fill( horizon );

		fill( cactus );
	}

	public static void main( String[] commands ) {
		proof( new DesertSkyRangersIcon() );
	}

}
