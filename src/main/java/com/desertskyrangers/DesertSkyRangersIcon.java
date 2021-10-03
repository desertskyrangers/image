package com.desertskyrangers;

import com.avereon.zerra.color.Colors;
import com.avereon.zerra.image.SvgIcon;
import com.avereon.zerra.image.VectorImageWriter;
import javafx.scene.paint.Color;

import java.nio.file.Paths;

public class DesertSkyRangersIcon extends SvgIcon {

	private final boolean renderPlane;

	private static final Color[] DESERT = new Color[]{ Color.web( "#b37c52" ), Color.web( "#4D4033" ), Color.web( "#6A806F" ) };

	private final Color[] theme = DESERT;

	public DesertSkyRangersIcon() {
		this( true );
	}

	public DesertSkyRangersIcon( boolean renderPlane ) {
		this.renderPlane = renderPlane;
	}

	@Override
	protected void doRender() {
		super.doRender();
		doRender2();
	}

	protected void doRender2() {
		String sun = circle( 16, 16, 15 );

		//String mountain = "M2,30 L2,26 L8,20 L10,22 L16,16 L22,22 L24,20 L30,26 L30,30 Z";
		String smallMountain = "M1,31 L1,27 L9,23 C10,22.5 10.75,22.25 11.5,22.25 C12.25,22.25 13,22.5 14,23 C18,25 26,29 30,29 L31,29 L31,31 Z";
		String bigMountain = "M15,22.5 L18,21     C19,20.5 19.75,20.25 20.5,20.25 C21.25,20.25 22,20.5 23,21 L31,25 L31,28 L30,28 C26,28 19,24.5 15,22.5 Z";
		String curvedMountain = smallMountain + bigMountain;

		String plane = "M16,6 L28,12 L27,13 L16,11 L5,13 L4,12 Z";
		String straightWisps = "M6,14 L8.5,14 L11.5,18 L10,18 M26,14 L22,18 L20.5,18 L23.5,14 Z";
		//String curvedWisps = "M13,15 L10,12 L12,11.75 A6,6,0,0,0,13,15 Z M19,15 L22,12 L20,11.75 A6,6,0,0,1,19,15 Z";

		String sunMountainClip = "M0,0 L0,26.5 L9,22 C10,21.5 10.75,21.25 11.5,21.25 C12.25,21.25 13,21.5 14,22 L18,20 C19,19.5 19.75,19.25 20.5,19.25 C21.25,19.25 22,19.5 23,20  L32,24.5 L32,0 Z";

		clip( sunMountainClip );
		fill( sun, theme[ 0 ] );
		clip( null );

		fill( curvedMountain, theme[ 2 ] );
		fill( plane, theme[ 1 ] );
		fill( straightWisps, Colors.mix( theme[ 0 ], theme[ 1 ], 0.5 ) );
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
		fill( sun, theme[ 0 ] );
		clip( null );

		if( renderPlane ) {
			fill( plane, theme[ 1 ] );
			fill( wisps, Colors.translucent( theme[ 1 ], 0.4 ) );
		}

		fill( cactus, theme[ 2 ] );
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
