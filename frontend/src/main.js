import Vue from 'vue';
import App from './App.vue';

//turn it later to false
Vue.config.productionTip = true

new Vue({
  render: h => h(App),
}).$mount('#app')
