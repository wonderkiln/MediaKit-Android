LOCAL_PATH:= $(call my-dir)

include $(CLEAR_VARS)
LOCAL_SRC_FILES := \
    src/dec/alpha.c \
    src/dec/frame.c \
    src/dec/idec.c \
    src/dec/layer.c \
    src/dec/quant.c \
    src/dec/tree.c \
    src/dec/vp8.c \
    src/dec/webp.c \
    src/dec/io.c \
    src/dec/buffer.c \
    src/dsp/yuv.c \
    src/dsp/upsampling.c \
    src/dsp/cpu.c \
    src/dsp/dec.c \
    src/dsp/dec_neon.c \
    src/dsp/enc.c \
    src/utils/bit_reader.c \
    src/utils/bit_writer.c \
    src/utils/thread.c \
    src/libwebp_java_wrap.c \

LOCAL_CFLAGS := -Wall -DANDROID -DHAVE_MALLOC_H -DHAVE_PTHREAD -DWEBP_USE_THREAD \
                -finline-functions -frename-registers -ffast-math \
                -s -fomit-frame-pointer -Isrc/webp

LOCAL_C_INCLUDES += $(LOCAL_PATH)/src

LOCAL_MODULE:= webp

include $(BUILD_SHARED_LIBRARY)
