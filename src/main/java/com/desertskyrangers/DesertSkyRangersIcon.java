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
