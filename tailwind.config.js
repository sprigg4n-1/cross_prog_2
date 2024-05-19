/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ['./src/main/resources/templates/**/*.html'],
  theme: {
    screens: {
      '2xl': {'max': '1535px'},

      'xl': {'max': '1279px'},

      'lg': {'max': '1023px'},

      'md': {'max': '767px'},

      'sm': {'max': '639px'},
    },
    extend: {},
  },
  plugins: [require('@tailwindcss/container-queries'),require('daisyui'),require('@tailwindcss/forms'),require('@tailwindcss/typography')],
}

