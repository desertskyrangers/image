package com.desertskyrangers;

import com.avereon.zarra.image.SvgIcon;
import com.avereon.zarra.image.VectorImage;
import com.avereon.zarra.image.VectorImageWriter;
import javafx.scene.shape.FillRule;

import java.nio.file.Path;
import java.nio.file.Paths;

public class FlightDeckIcon extends SvgIcon {

	public FlightDeckIcon() {
		fill( "M30,2 C29,4 26.5,7.5 24.5,9.5 L24.5,8 L24,8.5 L24,11 C20,15 14.5,19.5 9.5,24.5 L7.5,22.5 L12,18 C14,16 15.5,14 16.5,12 C22,9 25,6 26,4 C27,3 29.5,2 30,2 Z M10,22 A109,109 0 0 0 22,10 A 109,109 0 0 0 10,22 Z", FillRule.EVEN_ODD );


		// Canopy
		fill( "M16.8,11.4 Q18,9 20,7 C21.5,5.5 24,4 25.5,4 C24.5,6 21,9 16.8,11.4 Z" );

		// Tail
		fill( "M7.5,21.5 L5.5,16.5 L7.5,14.5 L12.5,16.5 Z" );

		// Nozzle
		fill( "M9,25 C8.6,25.4 7.4,25.6 7,26 L6,25 C6.4,24.6 6.6,23.4 7,23 Z" );

		// Flame
		fill( "M2,30 L4,27 C 4.5,27 5.5,26.5 6,26 C 5.5,26.5 5,27.5 5,28 Z" );
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
