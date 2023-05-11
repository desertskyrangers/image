package org.desertskyrangers.image;

import com.avereon.zarra.image.SvgIcon;
import com.avereon.zarra.image.VectorImageWriter;
import javafx.application.Platform;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Banner extends SvgIcon {

	//

	public static void main( String[] commands ) {
		Path root = Paths.get( System.getProperty( "user.dir" ) );

		Banner card = new Banner();
		// NEXT Assume 300 DPI and calculate for 24x96 inches
		card.resize( 1050, 600 );

		// FIXME Generalize this code
		new Thread( () -> {
			try {
				Path target = root.resolve( "dsr-banner.png" );
				new VectorImageWriter().save( card, target );
			} catch( Exception exception ) {
				exception.printStackTrace();
			} finally {
				Platform.exit();
			}
		} ).start();
	}
}
