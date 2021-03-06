package com.sleepingdreamlessly.osu.assets;

import com.sleepingdreamlessly.osu.Handler;
import com.sleepingdreamlessly.osu.audio.AudioClip;
import com.sleepingdreamlessly.osu.graphics.Sprite;

import java.util.ArrayList;

public class Assets
{
	// general
	private static ArrayList<Sprite> _sprites = new ArrayList<>();
	
	private static String name_skin = "dracula_final"; // @TODO: read this from (osu) ini
	private static String path_skin = "\\res\\skins\\" + name_skin + "\\";
	private static String path_songs = "\\res\\songs\\";
	private static String name_font_default = "default"; // @TODO: read these from skin.ini
	private static String name_font_score = "score";
	private static String name_font_combo = "combo";
	
	// osu
	public static Sprite inputoverlay_background, inputoverlay_key;
	public static Sprite hitcircle, hitcircleoverlay, approachcircle, cursor, cursortrail;
	public static Sprite std_hit0, std_hit50, std_hit50k, std_hit100, std_hit100k, std_hit300, std_hit300g, std_hit300k;
	
	// mania
	public static Sprite note;
	public static Sprite mania_hit0, mania_hit50, mania_hit100, mania_hit200, mania_hit300, mania_hit300g;
	
	public static Sprite[] font_default_numbers = new Sprite[10];
	public static Sprite[] font_score_numbers = new Sprite[10];
	public static Sprite[] font_combo_numbers = new Sprite[10];
	public static Sprite font_score_comma, font_score_dot, font_score_percent;
	
	// audio
	public static ArrayList<AudioClip> _samples = new ArrayList<>();
	
		/*
			hitsounds[sampleset][sound] >>
			sample sets: soft, normal, drum
			sound: normal, whistle, finish, clap
		 */
	public static AudioClip[][] hitsounds = new AudioClip[3][4]; // ;
	
	public Assets()
	{
		
	}
	
	public static void init(Handler handler)
	{
		cursor 				          = new Sprite(handler, "cursor");                   _sprites.add(cursor);
		cursortrail             = new Sprite(handler, "cursortrail");              _sprites.add(cursortrail);
		inputoverlay_background = new Sprite(handler, "inputoverlay-background");  _sprites.add(inputoverlay_background);
		inputoverlay_key        = new Sprite(handler, "inputoverlay-key");         _sprites.add(inputoverlay_key);
		
		// std
		hitcircle 				= new Sprite(handler, "hitcircle");        _sprites.add(hitcircle);
		approachcircle		= new Sprite(handler, "approachcircle");   _sprites.add(approachcircle);
		hitcircleoverlay 	= new Sprite(handler, "hitcircleoverlay"); _sprites.add(hitcircleoverlay);
		
		std_hit0          = new Sprite(handler, "hit0");             _sprites.add(std_hit0);
		std_hit50         = new Sprite(handler, "hit50");            _sprites.add(std_hit50);
		std_hit50k        = new Sprite(handler, "hit50k");           _sprites.add(std_hit50k);
		std_hit100        = new Sprite(handler, "hit100");           _sprites.add(std_hit100);
		std_hit100k       = new Sprite(handler, "hit100k");          _sprites.add(std_hit100k);
		std_hit300        = new Sprite(handler, "hit300");           _sprites.add(std_hit300);
		std_hit300k       = new Sprite(handler, "hit300k");          _sprites.add(std_hit300k);
		std_hit300g       = new Sprite(handler, "hit300g");          _sprites.add(std_hit300g);
		
		// mania
		note              = new Sprite(handler, "note");             _sprites.add(note);
		mania_hit0        = new Sprite(handler, "mania-hit0");       _sprites.add(mania_hit0);
		mania_hit50       = new Sprite(handler, "mania-hit50");      _sprites.add(mania_hit50);
		mania_hit100      = new Sprite(handler, "mania-hit100");     _sprites.add(mania_hit100);
		mania_hit200      = new Sprite(handler, "mania-hit200");     _sprites.add(mania_hit200);
		mania_hit300      = new Sprite(handler, "mania-hit300");     _sprites.add(mania_hit300);
		mania_hit300g     = new Sprite(handler, "mania-hit300g");    _sprites.add(mania_hit300g);
		
		// fonts
		for (int i = 0; i < 10; i++)
		{
			font_default_numbers[i] = new Sprite(handler, name_font_default  + "-" + Integer.toString(i));
			font_combo_numbers[i]   = new Sprite(handler, name_font_combo    + "-" + Integer.toString(i));
			font_score_numbers[i]   = new Sprite(handler, name_font_score    + "-" + Integer.toString(i));
			
			_sprites.add(font_default_numbers[i]);
			_sprites.add(font_combo_numbers[i]);
			_sprites.add(font_score_numbers[i]);
		}
		
		font_score_comma    = new Sprite(handler, name_font_score + "-" + "comma");
		font_score_dot      = new Sprite(handler, name_font_score + "-" + "dot");
		font_score_percent  = new Sprite(handler, name_font_score + "-" + "percent");
		
		// sounds
		for (int s = 0; s < 4; s++)
		{
			String soundName =
				(s == 0) ?
					"normal"  :
				(s == 1) ?
					"whistle" :
				(s == 2) ?
					"finish"  :
				(s == 3) ?
					"clap"    : "";
			
			hitsounds[0][s] = new AudioClip(handler, "soft-hit"    + soundName); _samples.add(hitsounds[0][s]);
			hitsounds[1][s] = new AudioClip(handler, "normal-hit"  + soundName); _samples.add(hitsounds[1][s]);
			hitsounds[2][s] = new AudioClip(handler, "drum-hit"    + soundName); _samples.add(hitsounds[2][s]);
		}
	}
	
	public String getSkinName()
	{
		return name_skin;
	}
	
	public static String getSkinPath()
	{
		return path_skin;
	}
	
	public static String getSongsPath()
	{
		return path_songs;
	}
	
	public static Sprite getSprite(String id)
	{
		for (Sprite s : _sprites)
			if (s.id.equals(id))
				return s;
		
		System.out.println("WARNING: Sprite " + id + " not found.");
		return null;
	}
	
	public static AudioClip getAudioClip(String id)
	{
		for (AudioClip a : _samples)
			if (a.id.equals(id))
				return a;
		
		System.out.println("WARNING: AudioClip (Sample) " + id + " not found.");
		return null;
	}
}
