// tailwind.config.js
const {heroui} = require("@heroui/theme");

/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./index.html",
    "./src/**/*.{js,ts,jsx,tsx}",
		"./node_modules/@heroui/theme/dist/**/*.{js,ts,jsx,tsx}",
    "./node_modules/@heroui/theme/dist/components/(table|checkbox|form|spacer).js",
    "./node_modules/@heroui/theme/dist/components/button.js",
    "./node_modules/@heroui/theme/dist/components/modal.js"
    
  ],
  theme: {
    extend: {
      colors: {
        laranja: '#FE7416',
        laranjaHouver: '#9F490F',
      }
    },
  },
  darkMode: "class",
  plugins: [heroui()],
};