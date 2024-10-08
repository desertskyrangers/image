package org.desertskyrangers.image;

import com.avereon.zarra.color.Paints;
import com.avereon.zarra.image.SvgIcon;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class DsrJet extends SvgIcon {

	private static final Color[] UTAH = new Color[]{ Color.web( "#b37c52" ), Color.web( "#403830" ), Color.web( "#9C916D" ), Color.web( "#807760" ) };

	public static final Color[] THEME = UTAH;

	private final Paint paint;

	private final boolean flame;

	public DsrJet() {
		this( null, false );
	}

	public DsrJet( Paint paint, boolean flame ) {
		super( 33, 9 );
		this.paint = paint;
		this.flame = flame;

		fill( getPath( flame ), paint );
	}

	public String toSvg() {
		String jetTransform = "transform=\" translate(0,-9)\"";

		StringBuilder svg = new StringBuilder();

		svg.append( "<svg width=\"" + getGridX() + "\" height=\"" + getGridY() + "\" xmlns=\"http://www.w3.org/2000/svg\">" );
		svg.append( "<path " + jetTransform + " fill=\"" + Paints.toString( paint ) + "\" d=\"" + getPath( flame ) + "\"/>" );
		svg.append( "</svg>" );

		return svg.toString();
	}

	public String getPath( boolean renderFlame ) {
		StringBuilder svg = new StringBuilder();

		// Wing
		double wr = 120.0 + (17.0 / 30.0);
		svg.append( "M5,16 A" + wr + "," + wr + " 0 0 0 22,16 A " + wr + "," + wr + " 0 0 0 5,16 Z" );

		// Fuselage
		svg.append( "M3,14.5 L10,14.5 C12,14.5 14.3,14.2 16.5,13.5 C18,14 22,15 24.5,15 C26,15 27.5,15 28.5,14.5 C30,14.6 32,15.3 33,16 C30,17 27,17.5 24,17.5 L24.5,16.5 L23,18 C17,18 10,17.5 3,17.5 Z" );

		// Canopy
		svg.append( "M17.3,13.2 C19.5,12.5 21,12.5 22.5,12.5 C25,12.5 27.5,13.5 28.1,14.1 C27.4,14.5 26,14.5 25,14.5 C22.5,14.5 18.8,13.7 17.3,13.2 Z" );

		// Tail
		svg.append( "M3.5,14 L5.5,9 L8.5,9 L10.5,14 Z" );

		// Nozzle
		svg.append( "M2.5,17.5 A6.5,6.5 0 0 1 0,17 L0,15 A6.5,6.5 0 0 1 2.5,14.5 Z" );

		// Flame
		if( renderFlame ) svg.append( " M-6,16 L-3,15.4 C-3,15.7 -2,16 -1.5,16 C-1.5,16 -3,16.3 -3,16.6 Z" );

		return svg.toString();
	}

	public static void main( String[] commands ) {
		proof( new DsrJet() );

		//		DsrJet icon = new DsrJet().resize( 512 );
		//
		//		Path target = Paths.get( System.getProperty( "user.home" ) ).resolve( "Data/dsr/code/software/flightdeck-react/public" );
		//		try {
		//			new VectorImageWriter().save( (VectorImage)icon.resize( 512 ), target.resolve( "logo512.png" ) );
		//			new VectorImageWriter().save( (VectorImage)icon.resize( 192 ), target.resolve( "logo192.png" ) );
		//			new VectorImageWriter().save( (VectorImage)icon.resize( 192 ), target.resolve( "logo.png" ) );
		//			new VectorImageWriter().save( (VectorImage)icon.resize( 64 ), target.resolve( "favicon.png" ) );
		//		} catch( Exception exception ) {
		//			exception.printStackTrace();
		//		}
	}

}
