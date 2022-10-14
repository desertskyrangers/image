package org.desertskyrangers.image;

import com.avereon.zarra.image.SvgIcon;
import com.avereon.zarra.image.VectorImage;
import com.avereon.zarra.image.VectorImageWriter;
import javafx.scene.paint.Paint;
import javafx.scene.transform.Affine;

import java.nio.file.Path;
import java.nio.file.Paths;

public class FlightDeckIcon extends SvgIcon {

	public FlightDeckIcon() {
		//render1( null, true );
		render2();
	}

	private void render2() {

		// Tower
		fill( "M10,30 L10,22 C10,20 10,18 8,16 L8,15 L24,15 L24,16 C22,18 22,20 22,22 L22,30 Z" );
//		fill( "M10,30 L10,20 C10,18 10,16 8,14 L8,13 L13,13 L13,14 C14,16 14,18 14,20 L14,30 Z" );
//		fill( "M15,30 L15,20 C15,18 15,16, 14,14 L14,13 L18,13 L18,14 C17,16 17,18 17,20 L17,30 Z" );
//		fill( "M18,30 L18,20 C18,18 18,16 19,14 L19,13 L24,13 L24,14 C22,16 22,18 22,20 L22,30 Z" );

		// Windows
		fill( "M9,14 L9,12 L13,12 L13,14 Z" );
		fill( "M14,14 L14,12 L18,12 L18,14 Z" );
		fill( "M19,14 L19,12 L23,12 L23,14 Z" );

		// Cap
		fill( "M8,11 L8,10 L10,8 L22,8 L24,10 L24,11 Z" );
//		fill( "M8,9 L8,8 L10,6 L14,6 L13,8 L13,9 Z" );
//		fill( "M14,9 L14,8 L15,6 L17,6 L18,8 L18,9 Z" );
//		fill( "M19,9 L19,8 L18,6 L22,6 L24,8 L24,9 Z" );

		// Plume
		fill( "M11.5,7 L10.5,5 L10.5,4 L21.5,4 L21.5,5 L20.5,7 Z" );
	}

	private void render1( Paint paint, boolean flame ) {
		double scale = 0.8;
		double offsetX = 16 - (16 * scale) + 2.25;
		double offsetY = 16 - (16 * scale);
		double angle = Math.toDegrees( Math.atan2( -1, 2 ) );
		transform( Affine.rotate( angle, 16, 16 ).createConcatenation( Affine.translate( offsetX, offsetY ) ).createConcatenation( Affine.scale( scale, scale ) ) );
		draw( new DsrJet( paint, flame ) );
	}

	public static void main( String[] commands ) {
		proof( new FlightDeckIcon() );

		FlightDeckIcon icon = new FlightDeckIcon().resize( 512 );

		Path target = Paths.get( System.getProperty( "user.home" ) ).resolve( "Data/dsr/code/software/flightdeck-react/public" );
		try {
			new VectorImageWriter().save( (VectorImage)icon.resize( 512 ), target.resolve( "logo512.png" ) );
			new VectorImageWriter().save( (VectorImage)icon.resize( 192 ), target.resolve( "logo192.png" ) );
			new VectorImageWriter().save( (VectorImage)icon.resize( 192 ), target.resolve( "logo.png" ) );
			new VectorImageWriter().save( (VectorImage)icon.resize( 64 ), target.resolve( "favicon.png" ) );
		} catch( Exception exception ) {
			exception.printStackTrace();
		}
	}

}
