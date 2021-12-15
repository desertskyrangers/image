package com.desertskyrangers;

import com.avereon.zarra.image.SvgIcon;
import com.avereon.zarra.image.VectorImage;
import com.avereon.zarra.image.VectorImageWriter;

import java.nio.file.Path;
import java.nio.file.Paths;

public class FlightLogIcon extends SvgIcon {

	public FlightLogIcon() {
		fill( "M28,4 A40,40,0,0,1,22,12 L8,26 L8,24 L6,24 L14,16 A40,40,0,0,0,21,10 A20,20,0,0,0,24,6 A15,15,0,0,1,28,4 Z" );

		// Canopy
		fill( "M14,15 A40,40,0,0,0,20,10 A15,15,0,0,0,23,6 A15,15,0,0,0,19,8 A40,40,0,0,0,14,15 Z" );

		// Tail
		fill( "M6,23 L4,18 L6,16 L11,18 Z" );

		// Flame
		fill( "M2,30 L4,27 L6,26 L5,28 Z" );
	}

	public static void main( String[] commands ) {
		proof( new FlightLogIcon() );

		FlightLogIcon icon = new FlightLogIcon().resize( 512 );

		Path target = Paths.get( System.getProperty( "user.home" ) ).resolve( "Data/dsr/code/software/flightlog-react/public" );
		try {
			new VectorImageWriter().save( icon, target.resolve( "logo512.png" ) );
			new VectorImageWriter().save( (VectorImage)icon.resize( 192 ), target.resolve( "logo192.png" ) );
			new VectorImageWriter().save( (VectorImage)icon.resize( 64 ), target.resolve( "favicon.png" ) );
		} catch( Exception exception ) {
			exception.printStackTrace();
		}
	}
}
