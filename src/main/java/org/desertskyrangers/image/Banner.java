package org.desertskyrangers.image;

import com.avereon.zarra.image.SvgIcon;
import com.avereon.zarra.image.VectorImageWriter;
import javafx.application.Platform;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.transform.Affine;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Banner extends SvgIcon {

	public Banner() {
		super( 128, 32 );

		double hMargin = 4;
		double vMargin = 2;
		double scale = (28 - 2 * hMargin) / 32;

		// Background
		//fill( "M0,0 L128,0 L128,32 L0,32 Z", DesertSkyRangersIcon.THEME[ 1 ] );
		fill( "M0,0 L128,0 L128,32 L0,32 Z" );

		// DSR logo
		//transform( Affine.translate( hMargin, vMargin ).createConcatenation( Affine.scale( scale, scale ) ) );
		draw( new DesertSkyRangersIcon() );

		// DSR text
		transform( Affine.translate( 34, 14 ).createConcatenation( Affine.scale( 0.7, 0.7 ) ) );
		setFont( Font.font(getFont().getName(), FontWeight.BOLD, getFont().getSize()) );
		text( "Desert Sky Rangers", DesertSkyRangersIcon.THEME[ 1 ] );

		setFont( Font.font(getFont().getName(), FontWeight.NORMAL, getFont().getSize()) );
		transform( Affine.translate( 35, 26 ).createConcatenation( Affine.scale( 0.4,0.4 ) ) );
		text( "https://www.desertskyrangers.org", DesertSkyRangersIcon.THEME[ 1 ] );
	}

	public static void main( String[] commands ) {
		Path root = Paths.get( System.getProperty( "user.dir" ) );

		// Maximum texture size: 16384
		int dpi = 72;
		Banner banner = new Banner();
		banner.resize( dpi * 96, dpi * 24 );

		// FIXME Generalize this code
		new Thread( () -> {
			try {
				Path target = root.resolve( "dsr-banner.png" );
				new VectorImageWriter().save( banner, target );
			} catch( Exception exception ) {
				exception.printStackTrace();
			} finally {
				Platform.exit();
			}
		} ).start();
	}
}
