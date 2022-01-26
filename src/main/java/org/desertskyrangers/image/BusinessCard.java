package org.desertskyrangers.image;

import com.avereon.zarra.image.SvgIcon;
import com.avereon.zarra.image.VectorImageWriter;
import javafx.application.Platform;
import javafx.scene.paint.Color;
import javafx.scene.transform.Affine;

import java.nio.file.Path;
import java.nio.file.Paths;

// Need to produce an image that is 1050x600
public class BusinessCard extends SvgIcon {

	public BusinessCard() {
		super( 56, 32 );

		double referenceWidth = 0.125;

		double hMargin = 4;
		double vMargin = 2;
		double scale = (28 - 2 * hMargin) / 32;

		// Reference divider
		//draw( "M28,0 L28,32", referenceWidth );

		// Background
		fill( "M0,0 L28,0 L28,32 L0,32 Z", DesertSkyRangersIcon.THEME[ 1 ] );
		fill( "M28,0 L56,0 L56,32 L28,32 Z" );

		// DSR logo
		transform( Affine.translate( hMargin, vMargin ).createConcatenation( Affine.scale( scale, scale ) ) );
		draw( new DesertSkyRangersIcon() );

		// DSR text
		transform( Affine.translate( hMargin, 26 ).createConcatenation( Affine.scale( 0.155, 0.155 ) ) );
		text( "Desert Sky Rangers" );
		transform( Affine.translate( hMargin, 28 ).createConcatenation( Affine.scale( 0.09, 0.09 ) ) );
		text( "https://www.desertskyrangers.org" );

		// Reference border
		//draw( "M0,0 L56,0 L56,32 L0,32 Z", 2 * referenceWidth );
	}

	public static void main( String[] commands ) {
		Path root = Paths.get( System.getProperty( "user.dir" ) );

		BusinessCard card = new BusinessCard();
		card.resize( 1050, 600 );

		new Thread( () -> {
			try {
				Path target = root.resolve( "dsr-business-card.png" );
				new VectorImageWriter().save( card, target );
			} catch( Exception exception ) {
				exception.printStackTrace();
			} finally {
				Platform.exit();
			}
		} ).start();
	}

}
