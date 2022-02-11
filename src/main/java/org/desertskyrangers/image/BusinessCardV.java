package org.desertskyrangers.image;

import com.avereon.zarra.image.SvgIcon;
import com.avereon.zarra.image.VectorImageWriter;
import javafx.application.Platform;
import javafx.scene.transform.Affine;

import java.nio.file.Path;
import java.nio.file.Paths;

// Need to produce an image that is 600x1050
public class BusinessCardV extends SvgIcon {

	private static final double DPI = 350;

	public BusinessCardV() {
		super( 32, 56 );

		double referenceWidth = 0.125;
		double hMargin = 1;
		double vMargin = 1;
		double scale = (getGridX() - 2 * hMargin) / getGridX();

		double indent = 2;

		// Background
		fill( "M0,0 L0,56 L32,56 L32,0 Z" );
		fill( "M0,0 L0,40 L32,40 L32,0 Z", DesertSkyRangersIcon.THEME[ 1 ] );

		// DSR logo
		transform( Affine.translate( hMargin, vMargin ).createConcatenation( Affine.scale( scale, scale ) ) );
		draw( new DesertSkyRangersIcon() );

		// DSR text
		transform( Affine.translate( indent, 34 ).createConcatenation( Affine.scale( 0.215, 0.215 ) ) );
		text( "Desert Sky Rangers" );
		transform( Affine.translate( indent, 37 ).createConcatenation( Affine.scale( 0.125, 0.125 ) ) );
		text( "https://www.desertskyrangers.org" );
	}

	public static void main( String[] commands ) {
		Path root = Paths.get( System.getProperty( "user.dir" ) );

		BusinessCardV card = new BusinessCardV();
		card.resize( 2 * DPI, 3.5 * DPI );

		new Thread( () -> {
			try {
				Path target = root.resolve( "dsr-business-card-v.png" );
				new VectorImageWriter().save( card, target );
			} catch( Exception exception ) {
				exception.printStackTrace();
			} finally {
				Platform.exit();
			}
		} ).start();
	}

}
