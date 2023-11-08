import {
    FONTFAMILY,
    FONTSIZE,
    FONTWEIGHT,
    LETTERSPACING,
    LINEHEIGHT
   
  } from "./index";
  
  const headline = {
    "4xl": {
      fontFamily: FONTFAMILY.fontPrimary,
      fontWeight: FONTWEIGHT.bold,
      fontSize: FONTSIZE["4xl"],
      letterSpacing: LETTERSPACING.trackingTight,
      lineHeight: LINEHEIGHT.normal,
    },
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
  };
  
  export default headline;
  