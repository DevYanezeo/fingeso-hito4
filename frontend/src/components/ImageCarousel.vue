<template>
    <div class="carousel">
      <img :src="images[currentImageIndex]" alt="Carrusel" />
    </div>
</template>
  
  <script>
  import image1 from '@/assets/image1.jpg';
  import image2 from '@/assets/image2.jpg';
  import image3 from '@/assets/image3.jpg';
  
  export default {
    data() {
      return {
        images: [image1, image2, image3],  // Utilizamos las imágenes importadas
        currentImageIndex: 0
      };
    },
    mounted() {
      setInterval(this.changeImage, 4000); // Cambia la imagen cada 3 segundos
    },
    methods: {
      changeImage() {
        this.currentImageIndex = (this.currentImageIndex + 1) % this.images.length;
      }
    }
  };
  </script>
  
  <style scoped>
  .carousel img {
    width: 100%;
    height: auto;
    border-radius: 8px;
    object-fit: cover;
  }
  </style>
  