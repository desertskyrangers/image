package org.desertskyrangers.image;

import com.avereon.zarra.image.SvgIcon;
import com.avereon.zarra.image.VectorImageWriter;

import java.nio.file.Paths;

public class PilotPlaceholderIcon extends SvgIcon {

	public PilotPlaceholderIcon() {
		String head = circle( 16, 10, 6 );
		String body = "M4,28 A12,10,0,0,1,28,28 Z";
		fill( head );
		fill( body );
	}

	public static void main( String[] commands ) {
		proof( new PilotPlaceholderIcon() );

		PilotPlaceholderIcon icon = new PilotPlaceholderIcon().resize( 128 );

		try {
			new VectorImageWriter().save( icon, Paths.get( System.getProperty( "user.dir" ), "../../websites/www.desertskyrangers.org/public", "pilot.png" ) );
		} catch( Exception exception ) {
			exception.printStackTrace();
		}
	}

}
