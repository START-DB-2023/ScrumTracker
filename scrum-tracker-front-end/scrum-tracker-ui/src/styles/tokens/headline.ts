import {
    FONTFAMILY,
    FONTSIZE,
    FONTWEIGHT,
    LETTERSPACING,
    LINEHEIGHT
   
  } from "./index";
  
  const headline = {
    "3xl": {
      fontFamily: FONTFAMILY.fontPrimary,
      fontWeight: FONTWEIGHT.bold,
      fontSize: FONTSIZE["3xl"],
      letterSpacing: LETTERSPACING.trackingTight,
      lineHeight: LINEHEIGHT.normal,
    },
    "2xl": {
      fontFamily: FONTFAMILY.fontPrimary,
      fontWeight: FONTWEIGHT.bold,
      fontSize: FONTSIZE["2xl"],
      letterSpacing: LETTERSPACING.trackingTight,
      lineHeight: LINEHEIGHT.normal,
    },
    xl: {
      fontFamily: FONTFAMILY.fontPrimary,
      fontWeight: FONTWEIGHT.bold,
      fontSize: FONTSIZE.xl,
      letterSpacing: LETTERSPACING.trackingTight,
      lineHeight: LINEHEIGHT.normal,
    },
  };
  
  export default headline;
  