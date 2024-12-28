<template>
    <div class="UserLogged">
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
    name: 'logged',
    components: {
      SearchSection,
      ImageCarousel,
      WhyRentWithUs
  }
};
</script>

<style scoped>
.UserLogged {
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