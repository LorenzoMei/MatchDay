(function ($) {
  "use strict";

  $(document).ready(function () {
    // Search Popup
    var bodyOvrelay = $("#body-overlay");
    var searchPopup = $("#search-popup");

    $(document).on("click", "#body-overlay", function (e) {
      e.preventDefault();
      bodyOvrelay.removeClass("active");
      searchPopup.removeClass("active");
    });
    $(document).on("click", ".search--toggler", function (e) {
      e.preventDefault();
      searchPopup.addClass("active");
      bodyOvrelay.addClass("active");
    });
    // Search Popup End

    // App Drawer - For Mobile Nav
    let appMenu = $(".app-nav__menu-link-important");
    if (appMenu) {
      appMenu.on("click", function (e) {
        e.preventDefault();
        $("body").toggleClass("app-nav__drawer-open");
        $(this).children().toggleClass("fa-bars fa-times");
      });
    }
    // App Drawer - For Mobile Nav End

    // Sub Category Drawer - For Mobile
    let subCategoryToggler = $(".sports-sub-category__toggler");
    let subCategoryClose = $(".sub-category-drawer__head-close");
    if (subCategoryToggler && subCategoryClose) {
      subCategoryToggler.on("click", function () {
        $("body").toggleClass("open-sub-category-drawer");
      });
      subCategoryClose.on("click", function () {
        $("body").removeClass("open-sub-category-drawer");
      });
    }
    // Sub Category Drawer - For Mobile End

    // Combine Checked
    let combineOption = $(".combine-option");

    if (combineOption) {
      combineOption.on("click", function () {
        if ($(this).is(":checked")) {
          $("body").addClass("combine-checked");
          $(".betslip-form").show();
          $(".betslip__list-return").hide();
        } else if ($(this).is(":not(:checked)")) {
          $("body").removeClass("combine-checked");
          $(".betslip-form").hide();
          $(".betslip__list-return").show();
        }
      });
    }
    // Combine Checked End

    // user Dashboard Menu Toggle
    let userMenuToggle = $(".dashboard-sidebar__nav-toggle-btn");
    let userMenuClose = $(".dashboard-menu__head-close");
    if (userMenuToggle || userMenuClose) {
      userMenuToggle.on("click", function () {
        $("body").toggleClass("dashboard-menu-open");
      });
      userMenuClose.on("click", function () {
        $("body").toggleClass("dashboard-menu-open");
      });
    }
    // user Dashboard Menu Toggle End

    // Add Support Ticket
    let addFile = $(".addFile");
    let removeFile = $(".removeFile");
    if (addFile || removeFile) {
      addFile.on("click", function () {
        $("#fileUploadsContainer").append(`
        <div class="input-group input--group">
        <input type="file" class="form-control form--control">
        <label class="input-group-text p-0">
            <button type="button" class="btn btn--add-more text--danger removeFile">Remove</button>
        </label>
      </div>
                `);
      });
      $(document).on("click", ".removeFile", function () {
        $(this).closest(".input-group").remove();
      });
    }
    // Add Support Ticket End

    // Custom Dropdown
    let customDropdown = $('[data-set="custom-dropdown"]');
    let dropdownContent = $(".custom-dropdown__content");
    if (customDropdown || dropdownContent) {
      customDropdown.each(function () {
        $(this).on("click", function (e) {
          e.stopPropagation();
          $("body").toggleClass("custom-dropdown-open");
          dropdownContent.toggleClass("is-open");
        });
      });
      dropdownContent.each(function () {
        $(this).on("click", function (e) {
          e.stopPropagation();
        });
      });
      $(document).on("click", function () {
        $("body").removeClass("custom-dropdown-open");
        dropdownContent.removeClass("is-open");
      });
    }
    // Custom Dropdown End

    // Password Show Hide Toggle
    let passTypeToggle = $(".pass-toggle");
    if (passTypeToggle) {
      passTypeToggle.each(function () {
        $(this).on("click", function () {
          $(this)
            .children()
            .toggleClass("las la-eye-slash")
            .toggleClass("las la-eye");
          var input = $(this).parent().find("input");
          if (input.attr("type") == "password") {
            input.attr("type", "text");
          } else {
            input.attr("type", "password");
          }
        });
      });
    }
    // Password Show Hide Toggle End

    // Category Slider

    let sportsCategory = $(".sports-category__list");
    let settings = {
      mobileFirst: true,
      variableWidth: true,
      infinite: true,
      slidesToShow: 1,
      swipeToSlide: true,
      prevArrow:
        '<button type="button" class="sports-category__arrow sports-category__arrow-prev"><i class="las la-angle-left"></i></button>',
      nextArrow:
        '<button type="button" class="sports-category__arrow sports-category__arrow-next"><i class="las la-angle-right"></i></button>',
    };
    if (parseInt(screenSize) < parseInt(992)) {
      if (sportsCategory || settings) {
        sportsCategory.slick(settings);
      }
    }
    // Category Slider end
  });
})(jQuery);

$(window).on("load", function () {
  // Preloader
  var preLoder = $(".preloader");
  preLoder.fadeOut(1000);
});

// Screen Size Counting
let screenSize = window.innerWidth;
window.addEventListener("resize", function (e) {
  screenSize = window.innerWidth;

  let sportsCategory = $(".sports-category__list");
  let settings = {
    mobileFirst: true,
    variableWidth: true,
    infinite: true,
    slidesToShow: 1,
    swipeToSlide: true,
    prevArrow:
      '<button type="button" class="sports-category__arrow sports-category__arrow-prev"><i class="las la-angle-left"></i></button>',
    nextArrow:
      '<button type="button" class="sports-category__arrow sports-category__arrow-next"><i class="las la-angle-right"></i></button>',
  };
  if (sportsCategory || settings) {
    if (parseInt(991) < parseInt(screenSize)) {
      if (sportsCategory.hasClass("slick-initialized")) {
        sportsCategory.slick("unslick");
        return;
      }
    }
    if (parseInt(screenSize) < parseInt(992)) {
      if (!sportsCategory.hasClass("slick-initialized")) {
        return sportsCategory.slick(settings);
      }
    }
    sportsCategory.on("swipe", function (event, slick, direction) {
      if (direction == "left") {
        $(this).addClass("arrow-prev-active");
      } else {
        $(this).removeClass("arrow-prev-active");
      }
    });
  }
});
// Screen Size Counting End