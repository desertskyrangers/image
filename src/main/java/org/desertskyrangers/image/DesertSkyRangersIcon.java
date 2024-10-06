package org.desertskyrangers.image;

import com.avereon.zarra.color.Colors;
import com.avereon.zarra.image.SvgIcon;
import com.avereon.zarra.image.VectorImageWriter;
import javafx.scene.paint.Color;
import javafx.scene.transform.Affine;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DesertSkyRangersIcon extends SvgIcon {

	private final boolean renderPlane;

	// Color theme is: sun, plane, mountains
	private static final Color[] ARIZONA = new Color[]{ Color.web( "#b37c52" ), Color.web( "#4D4033" ), Color.web( "#6A806F" ), Color.web( "#607C6A" ) };

	private static final Color[] UTAH = new Color[]{ Color.web( "#b37c52" ), Color.web( "#403830" ), Color.web( "#9C916D" ), Color.web( "#807760" ) };

	public static final Color[] THEME = UTAH;

	private static final double scale = 0.75;

	private static final double offsetX = 16 - (16 * scale);

	private static final double offsetY = 16 - (16 * scale) - 2;

	private static final double angle = Math.toDegrees( Math.atan2( -1, 2 ) );

	public DesertSkyRangersIcon() {
		this( true );
	}

	public DesertSkyRangersIcon( boolean renderPlane ) {
		this.renderPlane = renderPlane;
	}

	public void define() {
		fill( getSunPath(), THEME[ 0 ] );
		fill( getForeMountainPath(), THEME[ 3 ] );
		fill( getBackMountainPath(), THEME[ 2 ] );
		if( renderPlane ) {
			transform( Affine.rotate( angle, 16, 16 ).createConcatenation( Affine.translate( offsetX, offsetY ) ).createConcatenation( Affine.scale( scale, scale ) ) );
			draw( new DsrJet( THEME[ 1 ], false ) );
		}
	}

	public String getForeMountainPath() {
		return "M1,31 L1,27 L9,23 C10,22.5 10.75,22.25 11.5,22.25 C12.25,22.25 13,22.5 14,23 C18,25 26,29 30,29 L31,29 L31,31 Z";
	}

	public String getBackMountainPath() {
		return "M15,22.5 L18,21 C19,20.5 19.75,20.25 20.5,20.25 C21.25,20.25 22,20.5 23,21 L31,25 L31,28 L30,28 C26,28 19,24.5 15,22.5 Z";
	}

	public String getSunPath() {
		String sLeft = "3.733500838578397,24.633249580710796";
		String sRight = "29.21044369139217,23.105221845696086";
		return "M" + sLeft + " L9,22 C10,21.5 10.75,21.25 11.5,21.25 C12.25,21.25 13,21.5 14,22 L18,20 C19,19.5 19.75,19.25 20.5,19.25 C21.25,19.25 22,19.5 23,20  L" + sRight + " A15,15 0 1 0 " + sLeft + " Z";
	}

	//@Override
	public String toSvg() {
		String jetTransform = "transform=\"rotate(" + angle + ",16,16) scale(" + scale + "," + scale + ") translate(" + offsetX + "," + offsetY + ")\"";

		StringBuilder svg = new StringBuilder();
		svg.append( "<svg width=\"" + getGridX() + "\" height=\"" + getGridY() + "\" xmlns=\"http://www.w3.org/2000/svg\">" );
		svg.append( "<path fill=\"" + Colors.toString( THEME[ 3 ] ) + "\" d=\"" + getForeMountainPath() + "\"/>" );
		svg.append( "<path fill=\"" + Colors.toString( THEME[ 2 ] ) + "\" d=\"" + getBackMountainPath() + "\"/>" );
		svg.append( "<path fill=\"" + Colors.toString( THEME[ 0 ] ) + "\" d=\"" + getSunPath() + "\"/>" );
		svg.append( "<path " + jetTransform + " fill=\"" + Colors.toString( THEME[ 1 ] ) + "\" d=\"" + new DsrJet( THEME[ 1 ], false ).getPath( false ) + "\"/>" );
		svg.append( "</svg>" );

		return svg.toString();
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
			Files.writeString( Path.of( "icon.svg" ), new DesertSkyRangersIcon().toSvg() );
		} catch( IOException e ) {
			e.printStackTrace();
		}

		try {
			DesertSkyRangersIcon favicon = new DesertSkyRangersIcon( false ).resize( 64 );
			DesertSkyRangersIcon icon = new DesertSkyRangersIcon().resize( 128 );
			DesertSkyRangersIcon icon1024 = new DesertSkyRangersIcon().resize( 1024 );

			//new VectorImageWriter().save( favicon, Paths.get( System.getProperty( "user.dir" ), "public", "favicon.png" ) );
			//new VectorImageWriter().save( icon, Paths.get( System.getProperty( "user.dir" ), "public", "logo.png" ) );
			new VectorImageWriter().save( icon1024, Paths.get( System.getProperty( "user.dir" ), "logo-1024.png" ) );
		} catch( Exception exception ) {
			exception.printStackTrace();
		}
	}

}
