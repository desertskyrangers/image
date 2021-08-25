package com.desertskyrangers;

import com.avereon.zerra.image.SvgIcon;
import com.avereon.zerra.image.VectorImageWriter;
import javafx.scene.paint.Color;

import java.nio.file.Paths;

public class DesertSkyRangersIcon extends SvgIcon {

	private final boolean renderPlane;

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

		String sunCactusClip = "M0,0 L0,18 A3,3,0,0,1,4,15 L4,14 A4,4,0,0,1,12,14 L12,17 A3,3,0,0,1,16,20 A7,7,0,0,1,14,26  L32,26 L32,0 Z";
		//if( renderPlane ) sunCactusClip = sunCactusClip + " " + plane3;

		clip( sunCactusClip );
		fill( sun, Color.web( "#a06000" ) );
		clip( null );

		fill( cactus, Color.web( "#008000" ) );

		if( renderPlane ) {
			fill( plane, Color.web( "#202020" ) );
			fill( wisps, Color.web( "#00000020" ) );
		}
	}

	public static void main( String[] commands ) {
		// FIXME proof() uses the non-param constructor
		proof( new DesertSkyRangersIcon( true ) );

		try {
			DesertSkyRangersIcon favicon = new DesertSkyRangersIcon( false ).resize( 64 );
			DesertSkyRangersIcon icon = new DesertSkyRangersIcon().resize( 512 );

			new VectorImageWriter().save( favicon, Paths.get( System.getProperty( "user.dir" ), "favicon.png" ) );
			new VectorImageWriter().save( icon, Paths.get( System.getProperty( "user.dir" ), "icon.png" ) );
		} catch( Exception exception ) {
			exception.printStackTrace();
		}
	}

}
