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
		this( null, false );
	}

	public FlightDeckIcon( Paint paint, boolean flame ) {
		double scale = 0.8;
		double offsetX = 16 - (16 * scale) + 2;
		double offsetY = 16 - (16 * scale);
		double angle = Math.toDegrees( Math.atan2( -1, 2 ) );
		transform( Affine.rotate( angle, 16, 16 ).createConcatenation( Affine.translate( offsetX, offsetY ) ).createConcatenation( Affine.scale( scale, scale ) ) );
		draw( new DsrJet( paint, flame ) );
	}

	public static void main( String[] commands ) {
		proof( new FlightDeckIcon( null, true ) );

		FlightDeckIcon icon = new FlightDeckIcon( null, true ).resize( 512 );

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
