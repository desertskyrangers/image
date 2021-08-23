package com.desertskyrangers;

import com.avereon.zerra.image.SvgIcon;
import com.avereon.zerra.image.VectorImageWriter;

import java.nio.file.Paths;

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

		sunBottomClip = "M" + b + ",12 A4,4,0,0,1,12,14 L12,17 A3,3,0,0,1,16,20 A7,7,0,0,1,14,26  L32,26 L32,12 Z";
		//sunBottomClip = "M0,12 L0,32 L32,32 L32,12 Z";
		String horizon = "M2,28 L2,30 L4,30 L4,28 Z M12,28 L12,30 L30,30 L30,28 Z";
		String cactus = "M6,30 L6,26  A6,6,0,0,1,2,20 L2,18 A1,1,0,0,1,4,18 L4,20 A3,3,0,0,0,6,23 L6,14 A2,2,0,0,1,10,14 L10,24 A3,3,0,0,0,12,21 L12,20 A1,1,0,0,1,14,20 A6,6,0,01,10,27  L10,30 Z";

		String plane = "M2,4 L2,10 L22,10 A6,1,0,0,0,28,9 A6,2,0,0,0,24,7 A8,8,0,0,0,20,6  A12,12,0,0,0,14,7.5 L7,8 L5,4 Z M23,9 A3,1,0,0,0,20,8 A13,13,0,0,0,15,9 Z";

		String plane2 = "M10,4 L12,4 L14,8 L22,7 A4,1,0,0,1,26,8 A4,1,0,0,1,22,9 L10,9 Z";
		String plane3 = "M18,4 L20,4 L26,10 L20,16 L18,16 L20,10 Z M18,10 L17.5,11 L12.5,11 L12,10 L12.5,9 L17.5,9 Z";

		String plane4 = "M14,14 L14,12 L20,6 L26,12 L26,14 L20,12 Z M19,14 L20,13.5 L21,14 L21,20 L19,20Z";

		String sunCactusClip = "M0,0 L0,18 A3,3,0,0,1,4,15 L4,14 A4,4,0,0,1,12,14 L12,17 A3,3,0,0,1,16,20 A7,7,0,0,1,14,26  L32,26 L32,0 Z " + plane3;

		//		clip( sunTopClip );
		//		fill( sun );
		//		clip( null );

		//		clip( sunLeftClip );
		//		fill( sun );
		//		clip( null );

		clip( sunCactusClip );
		fill( sun );
		clip( null );

		//fill( horizon );

		fill( cactus );

		//fill( plane );
	}

	public static void main( String[] commands ) {
		proof( new DesertSkyRangersIcon() );

		try {
			DesertSkyRangersIcon favicon = new DesertSkyRangersIcon().resize( 64 );
			DesertSkyRangersIcon icon = new DesertSkyRangersIcon().resize( 512 );

			//new VectorImageWriter().save( favicon, Paths.get( System.getProperty( "user.dir" ), "favicon.png" ) );
			//new VectorImageWriter().save( icon, Paths.get( System.getProperty( "user.dir" ), "icon.png" ) );
		} catch( Exception exception ) {
			exception.printStackTrace();
		}
	}

}
