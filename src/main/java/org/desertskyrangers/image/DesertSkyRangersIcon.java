package org.desertskyrangers.image;

import com.avereon.zarra.color.Colors;
import com.avereon.zarra.image.SvgIcon;
import com.avereon.zarra.image.VectorImageWriter;
import javafx.scene.paint.Color;

import java.nio.file.Paths;

public class DesertSkyRangersIcon extends SvgIcon {

	private final boolean renderPlane;

	// Color theme is: sun, plane, mountains
	private static final Color[] ARIZONA = new Color[]{ Color.web( "#b37c52" ), Color.web( "#4D4033" ), Color.web( "#6A806F" ) };

	private static final Color[] UTAH = new Color[]{ Color.web( "#b37c52" ), Color.web( "#403830" ), Color.web( "#9C916D" ) };

	public static final Color[] THEME = UTAH;

	public DesertSkyRangersIcon() {
		this( true );
	}

	public DesertSkyRangersIcon( boolean renderPlane ) {
		this.renderPlane = renderPlane;
		doRender2();
	}

	protected void doRender2() {
		String sun = circle( 16, 16, 15 );

		String foreMountain = "M1,31 L1,27 L9,23 C10,22.5 10.75,22.25 11.5,22.25 C12.25,22.25 13,22.5 14,23 C18,25 26,29 30,29 L31,29 L31,31 Z";
		String backMountain = "M15,22.5 L18,21 C19,20.5 19.75,20.25 20.5,20.25 C21.25,20.25 22,20.5 23,21 L31,25 L31,28 L30,28 C26,28 19,24.5 15,22.5 Z";
		String mountains = foreMountain + backMountain;

		String vrr = "10.48875058760044,10.48875058760044";
		String plane = "M16,7 L28,13 L27,14 L16,12 L5,14 L4,13 Z";
		String wisps = "M7.5,14.75 L10,17.5 A" + vrr + ",0,0,1,6,15 Z M24.5,14.75 L26,15 A" + vrr + ",0,0,1,22,17.5 Z";
		wisps = "M 6,15 L7.5,14.75 L9,18 Z M23,18 L24.5,14.75 L26,15 Z";

		String sunMountainClip = "M0,0 L0,26.5 L9,22 C10,21.5 10.75,21.25 11.5,21.25 C12.25,21.25 13,21.5 14,22 L18,20 C19,19.5 19.75,19.25 20.5,19.25 C21.25,19.25 22,19.5 23,20  L32,24.5 L32,0 Z";

		clip( sunMountainClip );
		fill( sun, THEME[ 0 ] );
		restore();

		fill( mountains, THEME[ 2 ] );
		fill( plane, THEME[ 1 ] );
		fill( wisps, Colors.mix( THEME[ 0 ], THEME[ 1 ], 0.5 ) );
	}

	protected void doRender1() {
		super.doRender();

		String sun = circle( 16, 16, 14 );

		String cactus = "M6,30 L6,26  A6,6,0,0,1,2,20 L2,18 A1,1,0,0,1,4,18 L4,20 A3,3,0,0,0,6,23 L6,14 A2,2,0,0,1,10,14 L10,24 A3,3,0,0,0,12,21 L12,20 A1,1,0,0,1,14,20 A6,6,0,01,10,27  L10,30 Z";

		String plane = "M18,4 L20,4 L26,10 L20,16 L18,16 L20,10 Z";
		String wisps = "M18,8 L14,8 L14,6 L17.25,6 Z M18,12 L17.25,14 L14,14 L14,12 Z";
		String wisps2 = "M17,4 L13,4 A8,8,0,0,1,19,10 Z   M17,16 L13,16 A8,8,0,0,0,19,10 Z";
		String wisps3 = "M17,4 A32,32,0,0,0,2,4 A32,32,1,0,0,17,4   M17,16 A32,32,0,0,0,2,16 A32,32,1,0,0,17,16 Z   ";

		String sunCactusClip = "M0,0 L0,18 A3,3,0,0,1,4,15 L4,14 A4,4,0,0,1,12,14 L12,17 A3,3,0,0,1,16,20 A7,7,0,0,1,14,26  L32,26 L32,0 Z";
		//if( renderPlane ) sunCactusClip = sunCactusClip + " " + plane3;

		clip( sunCactusClip );
		fill( sun, THEME[ 0 ] );
		restore();

		if( renderPlane ) {
			fill( plane, THEME[ 1 ] );
			fill( wisps, Colors.translucent( THEME[ 1 ], 0.4 ) );
		}

		fill( cactus, THEME[ 2 ] );
	}

	public static void main( String[] commands ) {
		proof( new DesertSkyRangersIcon() );

		try {
			DesertSkyRangersIcon favicon = new DesertSkyRangersIcon( false ).resize( 64 );
			DesertSkyRangersIcon icon = new DesertSkyRangersIcon().resize( 128 );

			new VectorImageWriter().save( favicon, Paths.get( System.getProperty( "user.dir" ), "public", "favicon.png" ) );
			new VectorImageWriter().save( icon, Paths.get( System.getProperty( "user.dir" ), "public", "logo.png" ) );
		} catch( Exception exception ) {
			exception.printStackTrace();
		}
	}

}
