import type { Meta, StoryObj } from "@storybook/react";
import * as Stack from "../../components/common/Stack";
import PinkBox from "../../components/common/PinkBox";

const meta = {
  title: "common/HStack",
  component: Stack.HStack,
  parameters: {
    layout: "centered",
  },
  args: {},
} satisfies Meta<typeof Stack.HStack>;

export default meta;
type Story = StoryObj<typeof meta>;

export const Default: Story = {
  args: {
    children: [PinkBox(), PinkBox(), PinkBox(), PinkBox()],
  },
};
export const Rotated: Story = {
  args: {
    rotated: true,
    children: [PinkBox(), PinkBox(), PinkBox(), PinkBox()],
  },
};
