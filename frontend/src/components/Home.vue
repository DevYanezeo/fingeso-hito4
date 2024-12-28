<template>
    <div class="home">
      <!-- Puedes añadir más contenido aquí -->
      <section class="search">
        <SearchSection />
      </section>
      <section class="carousel">
        <ImageCarousel />
      </section>
      <section class="rentWithUs">
        <WhyRentWithUs />
      </section>
    </div>
</template>
  
<script>
import SearchSection from './SearchSection.vue';
import ImageCarousel from './ImageCarousel.vue';
import WhyRentWithUs from './WhyRentWithUs.vue';
  
export default {
    name: 'Home',
    components: {
      SearchSection,
      ImageCarousel,
      WhyRentWithUs
  }
};
</script>
  
<style scoped>
.home {
  text-align: center;
  margin-top: 50px;
  font-size: 18px;
  }
  
.search {
  margin-top: 30px;
  }
  
.carousel {
  margin-top: 30px;
  }
  
.rentWithUs {
  margin-top: 30px;
  }
 </style>
  