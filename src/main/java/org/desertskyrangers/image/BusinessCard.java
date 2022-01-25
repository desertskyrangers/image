package org.desertskyrangers.image;

import com.avereon.zarra.image.SvgIcon;
import com.avereon.zarra.image.VectorImageWriter;
import javafx.application.Platform;
import javafx.scene.transform.Affine;

import java.nio.file.Path;
import java.nio.file.Paths;

// Need to produce an image that is 1050x600
public class BusinessCard extends SvgIcon {

	public BusinessCard() {
		super( 56, 32 );

		draw( "M0,0 L56,0 L56,32 L0,32 Z", 1 );
		draw( Affine.translate(16,16), new DesertSkyRangersIcon() );
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
